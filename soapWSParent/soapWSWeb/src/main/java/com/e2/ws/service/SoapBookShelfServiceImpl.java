package com.e2.ws.service;


import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.e2.domain.Book;
import com.e2.service.IBookShelfService;

@Service("soapBookShelfServiceImpl")
@WebService(endpointInterface = "com.e2.ws.service.SoapBookShelfService", serviceName = "bookShelfService")
public class SoapBookShelfServiceImpl implements SoapBookShelfService {
	@Resource(name="bookShelfService")

	private IBookShelfService bookShelfService;
	
	@Override
	public long persisten(Book book) {
		return bookShelfService.persisten(book);
	}

	@Override
	public Book getBookByTitle(String title) {
		return bookShelfService.getBookByTitle(title);
	}

	@Override
	public Book getBookById(long bookId) {
		return bookShelfService.getBookById(bookId);
	}

	@Override
	public void removeBookById(long bookId) {
		bookShelfService.removeBookById(bookId);
	}

	@Override
	public List<Long> getBookIds() {
		return bookShelfService.getBookIds();
	}
}