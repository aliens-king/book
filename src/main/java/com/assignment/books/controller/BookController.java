package com.assignment.books.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.books.dto.BookDTO;
import com.assignment.books.dto.ResponseDTO;
import com.assignment.books.model.Book;
import com.assignment.books.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author SUDHANSHU
 *
 */
@RestController
@RequestMapping("/book")
@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"test-api-controller"}, description = "Testing API") 

public class BookController {

public static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	/**
	 * @param book
	 * @return
	 */

	@PostMapping("/save")
	@ApiOperation(value="Books getting saved ")
	@ApiResponses({
		@ApiResponse(code=101,message="sucessfully  books getting saved"),
		@ApiResponse(code=102,message="getting some issue in saveing the books")
	})
	public ResponseDTO createBookDetails(@RequestBody BookDTO book) {
		return bookService.saveBook(book);
	}

	/**
	 * @return
	 */

	@GetMapping(value = "/allBooks")
	@ApiOperation(value="Returns all book and cache implementation")
	@ApiResponses({
		@ApiResponse(code=101,message="sucessfully getting all the books"),
		@ApiResponse(code=102,message="getting some issue in getting all the books")
	})
   public List<Book> getAllBook() {
		return bookService.getAllBooks();

	}

	/**
	 * @param id
	 * @return
	 */

	@GetMapping("/{id}")
	@ApiOperation(value="Get Book By Id and cache implementation")
    @ApiResponses({
		@ApiResponse(code=101,message="sucessfully  getting the book"),
		@ApiResponse(code=102,message="getting some issue in getting the books")
	})

	public Book getBookById(@PathVariable(value = "id") Long id) {
		return bookService.getBookSingle(id);

	}

	/**
	 * @param id
	 * @param bookDTO
	 * @return
	 */

	@PutMapping("/update")
	@ApiOperation(value="Updateing the book list")
    @ApiResponses({
		@ApiResponse(code=101,message="sucessfully  getting updated"),
		@ApiResponse(code=102,message="getting some issue in updateing the books")
	})
	public BookDTO updateBookList(@RequestBody BookDTO bookDTO) {
		return bookService.updateBookList(bookDTO);

	}

	/**
	 * @param id
	 * @param bookDTO
	 * @return
	 */

	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleting the book based on id")
    @ApiResponses({
		@ApiResponse(code=101,message="sucessfully   book getting deleted"),
		@ApiResponse(code=102,message="getting some issue in deleteing the books")
	})
	public ResponseDTO deleteBook(@PathVariable(value = "id") Long id, BookDTO bookDTO) {
		return bookService.deletBook(id, bookDTO);
	}

}
