package com.e2.service;

import java.util.List;

import com.e2.domain.Book;

public interface IBookShelfService {
	public  long persisten(Book book); 
	public  Book getBookByTitle(String title);
	public Book getBookById(long bookId);
	public void removeBookById(long bookId);
	public List<Book> getBooks();
	public List<Long> getBookIds();
}
