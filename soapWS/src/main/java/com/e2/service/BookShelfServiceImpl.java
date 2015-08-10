package com.e2.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.e2.vo.BookVO;

@Service("bookShelfServiceImpl")
public class BookShelfServiceImpl implements BookShelfService {

	Map<String, BookVO> map = new HashMap<String, BookVO>();
	
	@Override
	public long insertBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		map.put(bookVO.getBookName(), bookVO);
		return 0;
	}

	@Override
	public BookVO getBook(String title) {
		// TODO Auto-generated method stub
		return map.get(title);
	}

}
