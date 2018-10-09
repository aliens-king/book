package com.assignment.books.serviceImpl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.assignment.books.dto.BookDTO;
import com.assignment.books.dto.MailDTO;
import com.assignment.books.dto.ResponseDTO;
import com.assignment.books.model.Book;
import com.assignment.books.model.EmailMessage;
import com.assignment.books.repo.BookRepository;
import com.assignment.books.service.BookService;
import com.assignment.books.utils.CustomHttpStatus;
import com.assignment.books.utils.DateUtils;
import com.assignment.books.utils.IConstants;
import com.assignment.books.utils.ReadWriteExcelUtils;

/**
 * @author SUDHANSHU
 *
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
	public static final String KEY = "cacheKey";
	public static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SimpleMailMessage simpleMailMessage;

	@Autowired
	public BookServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.books.service.BookService#saveBook(com.assignment.books.dto.
	 * BookDTO)
	 */
	@Override
	public ResponseDTO saveBook(BookDTO bookDTO) {
		ResponseDTO responseDTO = null;
		if (bookDTO != null) {
			try {
				Book book = getBookObj(bookDTO);
				book = bookRepository.save(book);
				bookDTO = getBookDTOObj(book);
				logger.info("Books got saved");
				responseDTO = new ResponseDTO(HttpStatus.OK, CustomHttpStatus.BookHTTPStatus.SUCCESS.getValue(),
						bookDTO, "Book Details sucessfully saved.");
			} catch (Exception e) {
				responseDTO = new ResponseDTO(HttpStatus.OK, CustomHttpStatus.BookHTTPStatus.FAILED.getValue(), null,
						"Something went wrong while saving book details.");
				e.printStackTrace();
			}
		}
		return responseDTO;
	}

	/**
	 * @param book
	 * @return
	 */
	private BookDTO getBookDTOObj(Book book) {
		BookDTO bookDTO = null;
		if (null != book) {
			bookDTO = new BookDTO();
			bookDTO.setTitle(book.getTitle());
			bookDTO.setCategory(book.getCategory());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setNumberOfPages(book.getNumberOfPages());
			bookDTO.setYear(book.getYear());
			bookDTO.setAuther(book.getAuther());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPrice(book.getPrice());

		}
		return bookDTO;

	}

	/**
	 * @param bookDTO
	 * @return
	 */
	private Book getBookObj(BookDTO bookDTO) {
		Book book = null;
		if (null != bookDTO) {
			book = new Book();
			if (null != bookDTO.getBookId())
				book.setId(bookDTO.getBookId());
			book.setTitle(bookDTO.getTitle());
			book.setCategory(bookDTO.getCategory());
			book.setIsbn(bookDTO.getIsbn());
			book.setNumberOfPages(bookDTO.getNumberOfPages());
			book.setYear(bookDTO.getYear());
			book.setAuther(bookDTO.getAuther());
			book.setPublisher(bookDTO.getPublisher());
			book.setPrice(bookDTO.getPrice());
			book.setReleaseDate(DateUtils.getDateObj(bookDTO.getReleaseDate(), IConstants.DATE_FORMAT));
		}
		return book;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.books.service.BookService#getAllBooks()
	 * 
	 * --------------- cache implemented--------------------------------------
	 */
	@Override
	@Cacheable(value = "booksCache", key = "#root.target.KEY")
	public List<Book> getAllBooks() {
		List<Book> lisOfBooks = bookRepository.findAll();
		// We are generating Excel file here.
		logger.info("getting info from data base");
		

		String excelFileName = ReadWriteExcelUtils.writeExcelFileFromList(lisOfBooks, IConstants.EXCEL_FILE_NAME);
		sendSimpleMessage(excelFileName);
		return lisOfBooks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.books.service.BookService#getBookSingle(java.lang.Long)
	 * --------------- cache implemented--------------------------------------
	 */
	@Override
	@Cacheable(value = "booksCache", key = "#id")
	public Book getBookSingle(Long id) {
		logger.info("Got the desired book");
		return bookRepository.findOne(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.books.service.BookService#updateBookList(java.lang.Long,
	 * com.assignment.books.dto.BookDTO)
	 */
	@Override
	public BookDTO updateBookList(BookDTO bookDTO) {

		Book book = bookRepository.findOne(bookDTO.getBookId());
		// bookDTO.setTitle(book.getTitle());
		bookDTO.setTitle("Demo Book Version");
		book = bookRepository.save(book);
		logger.info("Book list got updated");

		return bookDTO;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.books.service.BookService#deletBook(java.lang.Long,
	 * com.assignment.books.dto.BookDTO)
	 */
	@Override
	public ResponseDTO deletBook(Long id, BookDTO bookDTO) {
		ResponseDTO responseDTO = null;
		if (bookDTO != null) {
			try {
				bookRepository.delete(id);
				logger.info(" Required Book got deleted");

				responseDTO = new ResponseDTO(HttpStatus.OK, CustomHttpStatus.BookHTTPStatus.SUCCESS.getValue(),
						bookDTO, "Book Details sucessfully deleted.");
			} catch (Exception e) {
				responseDTO = new ResponseDTO(HttpStatus.OK, CustomHttpStatus.BookHTTPStatus.FAILED.getValue(), null,
						"Something went wrong while deleting book details.");
				e.printStackTrace();
			}
		}
		return responseDTO;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.books.service.BookService#sendMail(com.assignment.books.model.
	 * EmailMessage)
	 */
	public void sendMail(EmailMessage emailMessage) throws MailException, MessagingException {
		SimpleMailMessage msg = new SimpleMailMessage(this.simpleMailMessage);
		msg.setTo("sudhanshuchaturvedi09@gmail.com");
		msg.setSubject("Test Subject");
		msg.setText("Hello World Message");

		try {

			MimeMessage message = javaMailSender.createMimeMessage();
		} catch (MailException ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.books.service.BookService#sendSimpleMessage(com.assignment.
	 * books.dto.MailDTO)
	 */
	@Scheduled(cron="0 1 1 * * *")
	public void sendSimpleMessage(String fileName) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setSubject("Books Details");
			helper.setText("This is book details.");

			helper.setTo("sudhanshuchaturvedi09@gmail.com");
			helper.setFrom("pramod.insonix@gmail.com");
			
			
			helper.addAttachment("BookDetails.xlsx", new File(fileName));
			javaMailSender.send(message);
			logger.info("MAil Sent,please Check");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}




}
