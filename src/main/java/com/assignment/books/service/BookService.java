package com.assignment.books.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import com.assignment.books.dto.BookDTO;
import com.assignment.books.dto.MailDTO;
import com.assignment.books.dto.ResponseDTO;
import com.assignment.books.model.Book;
import com.assignment.books.model.EmailMessage;

/**
 * @author SUDHANSHU
 *
 */
public interface BookService {

	public ResponseDTO saveBook(BookDTO book);

	public List<Book> getAllBooks();


	public Book getBookSingle(Long id);

	public BookDTO updateBookList(BookDTO bookDTO);

	public ResponseDTO deletBook(Long id, BookDTO bookDTO);

	public void sendMail(EmailMessage emailMessage) throws MailException, MessagingException;


	public void sendSimpleMessage(String mailFileName);

}
