package com.e2.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.e2.domain.Employee;
import com.e2.domain.Phone;
import com.e2.service.IEmployeeInfoService;
import com.e2.web.form.EmployeeInfoForm;

public class ViewEmployeeDetailAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			IEmployeeInfoService employeeInfoService = (IEmployeeInfoService) getWebApplicationContext()
					.getBean("employeeInfoService");

			EmployeeInfoForm employeeInfoForm = (EmployeeInfoForm) form;
			Employee employee = new Employee();
			
			employee = employeeInfoService.getEmployeeById(employeeInfoForm.getEmployeeId());
			
			employeeInfoForm.setFirstName(employee.getFirstName());
			employeeInfoForm.setLastName(employee.getLastName());
			
			List<Phone> phones = new ArrayList<Phone>();
			phones = employee.getPhone();
			
			for(Phone phone : phones)
			{
				String type = phone.getPhoneType();
				if(type.equals("work"))
				{
					employeeInfoForm.setWorkPhoneNumber(phone.getPhoneNumber());
					employeeInfoForm.setWorkPhoneId(phone.getPhoneId());
				}
				else if(type.equals("home"))
				{
					employeeInfoForm.setHomePhoneNumber(phone.getPhoneNumber());
					employeeInfoForm.setHomePhoneId(phone.getPhoneId());
				}
				else if(type.equals("mobile"))
				{
					employeeInfoForm.setMobilePhoneNumber(phone.getPhoneNumber());
					employeeInfoForm.setMobilePhoneId(phone.getPhoneId());
				}	
			}
			
			return mapping.findForward("success");
			
		} catch (Exception e) {
			return mapping.findForward("fail");
		}
	}
}