<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%
	//allow access only if session exists 
	String user = (String) session.getAttribute("user");
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user"))
				userName = cookie.getValue();
			if (cookie.getName().equals("JSESSIONID"))
				sessionID = cookie.getValue();
		}
	} else {
		sessionID = session.getId();
	}
%>
<h3>
Hi
<%=userName%>, Login successful. Your Session ID=<%=sessionID%></h3>
<br> User=<%=user%>
<br>


<a href="<%=response.encodeURL("hello")%>">Checkout
Page</a>
<form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>