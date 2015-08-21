package com.e2.ws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.e2.domain.Book;

@WebService(targetNamespace = "com.e2.ws.service.bookShelf", name = "bookShelf")
@SOAPBinding(style = Style.DOCUMENT)
public interface SoapBookShelfService {
	
	
	@WebMethod(operationName = "persisten")
	public long persisten(
		@WebParam(name = "title", mode = Mode.IN) Book book);
	
    @WebMethod(operationName = "getBookByTitle")
	public Book getBookByTitle(
		@WebParam(name = "book", mode = Mode.IN) String title);

	@WebMethod(operationName = "getBookById")
	public Book getBookById(
		@WebParam(name = "book", mode = Mode.IN) long bookId);

	@WebMethod(operationName = "removeBookById")
	public void removeBookById(@WebParam(name = "remove", mode = Mode.IN) long bookId);

	@WebMethod//(operationName = "getBookIds")
	public List<Long> getBookIds();
}