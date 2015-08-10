package com.e2.ws.service;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.e2.service.BookShelfService;
import com.e2.vo.BookVO;

@Service("soapBookShelfServiceImpl")
@WebService(endpointInterface = "com.e2.ws.service.SoapBookShelfService", serviceName = "bookShelfService")
public class SoapBookShelfServiceImpl implements SoapBookShelfService {
	@Resource(name="bookShelfServiceImpl")
	//@Autowired
	//@Qualifier("paymentServiceImpl")
	private BookShelfService bookShelfService;
	
	@Override
	public long insertBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		return bookShelfService.insertBook(bookVO);
	}

	@Override
	public BookVO getBook(String title) {
		// TODO Auto-generated method stub
		return bookShelfService.getBook(title);
	}
	
	public void setBookShelfService(BookShelfService bookShelfService) {
		this.bookShelfService = bookShelfService;
	}
}
