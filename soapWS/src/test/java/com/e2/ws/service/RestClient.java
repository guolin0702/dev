package com.e2.ws.service;

import java.net.URLEncoder;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;


public class RestClient {
	private static final String getURL = "http://localhost:8080/soapWS/services/bookShelfServiceRest/bookService/getbook/";
	private static final String addURL = "http://localhost:8080/soapWS/services/bookShelfServiceRest/bookService/addbook/";
	private static final String addTwoURL = "http://localhost:8080/soapWS/services/bookShelfServiceRest/bookService/addTwoBooks/";

	public static void main(String[] args) {
		RestClient client = new RestClient();
		try {
			client.addBook("Foundation and Earth", "Issac Asimov");
			client.addBook("Foundation and Empire", "Issac Asimov");
			client.addBookJSON("Rama Revealed", "Arthur C Clarke");
			client.getBookXML("Rama Revealed");

			client.getBookJSON("Rama Revealed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBookJSON(String bookName) throws Exception {
		String output = null;
		try {
			String restURL = getURL + URLEncoder.encode(bookName, "UTF-8");
			HttpClient client = new HttpClient();

			PostMethod mPost = new PostMethod(restURL);
			// client.executeMethod( mPost );
			Header mtHeader = new Header();
			mtHeader.setName("content-type");
			mtHeader.setValue("application/x-www-form-urlencoded");
			mtHeader.setName("accept");
			mtHeader.setValue("application/json");
			// mtHeader.setValue("/");
			mPost.addRequestHeader(mtHeader);

			client.executeMethod(mPost);
			output = mPost.getResponseBodyAsString();
			mPost.releaseConnection();
			System.out.println("out : " + output);
			return output;
		} catch (Exception e) {
			throw new Exception("Exception in retriving group page info : " + e);
		}
	}

	public String getBookXML(String bookName) throws Exception {
		String output = null;
		try {
			String restURL = getURL + URLEncoder.encode(bookName, "UTF-8");
			HttpClient client = new HttpClient();
			PostMethod mPost = new PostMethod(restURL);
			// client.executeMethod( mPost );
			Header mtHeader = new Header();
			mtHeader.setName("content-type");
			mtHeader.setValue("application/x-www-form-urlencoded");
			mtHeader.setName("accept");
			mtHeader.setValue("application/xml");
			mPost.addRequestHeader(mtHeader);

			client.executeMethod(mPost);
			output = mPost.getResponseBodyAsString();
			mPost.releaseConnection();
			System.out.println("out : " + output);
			return output;
		} catch (Exception e) {
			throw new Exception("Exception in retriving group page info : " + e);
		}
	}

	public void addBook(String bookName, String author) throws Exception {
		String output = null;
		try {
			HttpClient client = new HttpClient();
			PostMethod mPost = new PostMethod(addURL);

			mPost.addParameter("name", bookName);
			mPost.addParameter("author", author);
			
			Header mtHeader = new Header();
			mtHeader.setName("content-type");
			mtHeader.setValue("application/x-www-form-urlencoded");
			
			mtHeader.setName("accept");
			mtHeader.setValue("application/xml");
			mPost.addRequestHeader(mtHeader);

			client.executeMethod(mPost);
			output = mPost.getResponseBodyAsString();
			mPost.releaseConnection();
			System.out.println("output : " + output);
		} catch (Exception e) {
			throw new Exception("Exception in adding bucket : " + e);
		}
	}

	public void addBookJSON(String bookName, String author) throws Exception {
		String output = null;
		try {
			HttpClient client = new HttpClient();
			PostMethod mPost = new PostMethod(addURL);

			mPost.addParameter("name", bookName);
			mPost.addParameter("author", author);
			Header mtHeader = new Header();
			mtHeader.setName("content-type");
			mtHeader.setValue("application/x-www-form-urlencoded");
			mtHeader.setName("accept");
			mtHeader.setValue("application/json");
			mPost.addRequestHeader(mtHeader);

			client.executeMethod(mPost);
			output = mPost.getResponseBodyAsString();
			mPost.releaseConnection();
			System.out.println("output : " + output);
		} catch (Exception e) {
			throw new Exception("Exception in adding bucket : " + e);
		}
	}
	
	public String testGetBookJSON(String bookName) throws Exception {
		String output = null;
		try {
			String restURL = addTwoURL + URLEncoder.encode(bookName, "UTF-8");
			HttpClient client = new HttpClient();

			PostMethod mPost = new PostMethod(restURL);
			// client.executeMethod( mPost );
			Header mtHeader = new Header();
			mtHeader.setName("content-type");
			mtHeader.setValue("application/x-www-form-urlencoded");
			mtHeader.setName("accept");
			mtHeader.setValue("application/json");
			// mtHeader.setValue("/");
			mPost.addRequestHeader(mtHeader);

			client.executeMethod(mPost);
			output = mPost.getResponseBodyAsString();
			mPost.releaseConnection();
			System.out.println("out : " + output);
			return output;
		} catch (Exception e) {
			throw new Exception("Exception in retriving group page info : " + e);
		}
	}
}