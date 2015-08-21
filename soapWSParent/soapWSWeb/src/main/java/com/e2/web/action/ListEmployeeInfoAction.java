package com.e2.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.e2.domain.Book;
import com.e2.domain.Employee;
import com.e2.domain.Phone;
import com.e2.service.IBookShelfService;
import com.e2.service.IEmployeeInfoService;
import com.e2.web.form.BookListForm;
import com.e2.web.form.EmployeeInfoListForm;

public class ListEmployeeInfoAction extends ActionSupport {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		IEmployeeInfoService employeeInfoService = (IEmployeeInfoService) getWebApplicationContext()
				.getBean("employeeInfoService");

		EmployeeInfoListForm employeeInfoListForm = (EmployeeInfoListForm) form;

		List<Employee> employeeList = employeeInfoService.getEmployee();

		employeeInfoListForm.setEmployees(employeeList);
		
		List<Phone> phoneList = employeeInfoService.getPhone();
		
		employeeInfoListForm.setPhones(phoneList);
		
		return mapping.findForward("success");

	}
}