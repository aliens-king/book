package com.assignment.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.books.model.Book;

/**
 * @author SUDHANSHU
 *
 */
@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {

}
