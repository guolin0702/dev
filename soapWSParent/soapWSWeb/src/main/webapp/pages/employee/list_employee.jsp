<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>
<body>
	<h2>List Employee Table and Phone Table</h2>
	<%
		out.println("Employee Table:");
	%>
	<table border="1">
		<tr>
			<td>Employee ID</td>
			<td>First Name</td>
			<td>Last Name</td>
		</tr>

		<logic:iterate id="employeeInfo" name="employeeInfoListForm"
			property="employees">
			<c:url var="myURL" value="viewEmployeeDetail.do">
				<c:param name="employeeId" value="${employeeInfo.employeeId}" />
			</c:url>

			<tr>

				<td><a href="${myURL}"><bean:write name="employeeInfo"
							property="employeeId" /></a></td>
				<td><bean:write name="employeeInfo" property="firstName" /></td>
				<td><bean:write name="employeeInfo" property="lastName" /></td>
			</tr>
		</logic:iterate>

	</table>

	<%
		out.println("");
		out.println("Phone Table:");
	%>
	<table border="1">
		<tr>
			<td>Phone ID</td>
			<td>Phone Type</td>
			<td>Phone Number</td>
			<td>Employee ID</td>
		</tr>

		<logic:iterate id="phone" name="employeeInfoListForm"
			property="phones">
			<tr>
				<td><bean:write name="phone" property="phoneId" /></td>
				<td><bean:write name="phone" property="phoneType" /></td>
				<td><bean:write name="phone" property="phoneNumber" /></td>
				<td><bean:write name="phone" property="employee.employeeId" /></td>
			</tr>
		</logic:iterate>

	</table>

	<br />
	<br />
	<html:link action="/addEmployeePage.do">Add Employee</html:link>
</body>
</html>
