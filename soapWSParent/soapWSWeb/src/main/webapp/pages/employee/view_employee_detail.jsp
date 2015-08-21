<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
</head>
<body>

	<h1>View Employee Detail Info</h1>
	<table border="1">
		<tr>
			<td>Employee ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Work Phone ID</td>
			<td>Work Phone</td>
			<td>Home Phone ID</td>
			<td>Home Phone</td>
			<td>Mobile Phone ID</td>
			<td>Mobile Phone</td>
		</tr>

		<tr>
			<td><bean:write name="employeeInfoForm" property="employeeId" /></td>
			<td contenteditable='true'><bean:write name="employeeInfoForm"
					property="firstName" /></td>
			<td contenteditable='true'><bean:write name="employeeInfoForm"
					property="lastName" /></td>
			<td><bean:write name="employeeInfoForm" property="workPhoneId" /></td>
			<td contenteditable='true'><bean:write name="employeeInfoForm"
					property="workPhoneNumber" /></td>
			<td><bean:write name="employeeInfoForm" property="homePhoneId" /></td>
			<td contenteditable='true'><bean:write name="employeeInfoForm"
					property="homePhoneNumber" /></td>
			<td><bean:write name="employeeInfoForm" property="mobilePhoneId" /></td>
			<td contenteditable='true'><bean:write name="employeeInfoForm"
					property="mobilePhoneNumber" /></td>
		</tr>

	</table>

	<html:form action="/updateEmployee.do">


		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="employee.label.firstname" />
				:
			</div>
			<html:text value='${employeeInfoForm.firstName}' property="firstName"
				size="40" maxlength="20" />
				<input type='hidden' name='employeeId' value='${employeeInfoForm.employeeId}'>
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="employee.label.lastname" />
				:
			</div>
			<html:text property="lastName" size="40" maxlength="20"
				value='${employeeInfoForm.lastName}' />
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="phone.label.work" />
				:
			</div>
			<html:text property="workPhoneNumber" size="40" maxlength="20"
				value='${employeeInfoForm.workPhoneNumber}' />
			<input type='hidden' name='workPhoneId' value='${employeeInfoForm.workPhoneId}'>
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="phone.label.home" />
				:
			</div>
			<html:text property="homePhoneNumber" size="40" maxlength="20"
				value='${employeeInfoForm.homePhoneNumber}' />
				<input type='hidden' name='homePhoneId' value='${employeeInfoForm.homePhoneId}'>
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="phone.label.mobile" />
				:
			</div>
			<html:text property="mobilePhoneNumber" size="40" maxlength="20"
				value='${employeeInfoForm.mobilePhoneNumber}' />
				<input type='hidden' name='mobilePhoneId' value='${employeeInfoForm.mobilePhoneId}'>
		</div>

		<div style="padding: 16px">
			<div style="float: left; padding-right: 8px;">
				<html:submit>
					<bean:message key="employee.label.button.submit" />
				</html:submit>
			</div>
		</div>

	</html:form>

</body>
</html>