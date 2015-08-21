<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
</head>
<body>
	<h1>Struct Demo</h1>

	<h2>Add Employee</h2>
	<div style="color: red">
		<html:errors />
	</div>

	<html:form action="/addEmployee.do">


		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="employee.label.firstname" />
				:
			</div>
			<html:text property="firstName" size="40" maxlength="20" />
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="employee.label.lastname" />
				:
			</div>
			<html:text property="lastName" size="40" maxlength="20" />
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="phone.label.work" />
				:
			</div>
			<html:text property="workPhoneNumber" size="40" maxlength="20" value="" />
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="phone.label.home" />
				:
			</div>
			<html:text property="homePhoneNumber" size="40" maxlength="20" value=""/>
		</div>

		<div style="padding: 16px">
			<div style="float: left; width: 100px;">
				<bean:message key="phone.label.mobile" />
				:
			</div>
			<html:text property="mobilePhoneNumber" size="40" maxlength="20" value=""/>
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