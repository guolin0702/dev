package com.e2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e2.dao.BookShelfServiceDao;
import com.e2.domain.Book;

@Transactional
@Service("bookShelfService")
public class BookShelfService implements IBookShelfService{

	@Autowired
	@Qualifier("bookShelfServiceDaoImpl")
	
	BookShelfServiceDao serviceDao;
	
	@Override
	public long persisten(Book book) {
		return serviceDao.persisten(book);
	}

	@Override
	public Book getBookByTitle(String title) {
		return serviceDao.getBookByTitle(title);
	}

	@Override
	public Book getBookById(long bookId) {
		return serviceDao.getBookById(bookId);
	}

	@Override
	public void removeBookById(long bookId) {
	    serviceDao.removeBookById(bookId);
	}

	@Override
	public List<Long> getBookIds() {
		return serviceDao.getBookIds();
	}

	@Override
	public List<Book> getBooks() {
		return serviceDao.getBooks();
	}

}
