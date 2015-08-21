package com.e2.web.action;

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

public class UpdateEmployeeAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			IEmployeeInfoService employeeInfoService = (IEmployeeInfoService) getWebApplicationContext()
					.getBean("employeeInfoService");

			EmployeeInfoForm employeeInfoForm = (EmployeeInfoForm) form;
			Employee employee = new Employee();
			employee.setEmployeeId(employeeInfoForm.getEmployeeId());
			employee.setFirstName(employeeInfoForm.getFirstName());
			employee.setLastName(employeeInfoForm.getLastName());
			// save it

			if (employeeInfoForm.getWorkPhoneNumber() != null
					&& employeeInfoForm.getWorkPhoneNumber().length() != 0) {
				Phone workPhone = new Phone();
				workPhone.setPhoneNumber(employeeInfoForm.getWorkPhoneNumber());
				workPhone.setPhoneId(employeeInfoForm.getWorkPhoneId());
				workPhone.setPhoneType("work");
				workPhone.setEmployee(employee);
				employee.addPhone(workPhone);
				// employeeInfoService.addPhone(workPhone);
			}

			if (employeeInfoForm.getHomePhoneNumber() != null
					&& employeeInfoForm.getHomePhoneNumber().length() != 0) {
				Phone homePhone = new Phone();
				homePhone.setPhoneNumber(employeeInfoForm.getHomePhoneNumber());
				homePhone.setPhoneId(employeeInfoForm.getHomePhoneId());
				homePhone.setPhoneType("home");
				homePhone.setEmployee(employee);
				employee.addPhone(homePhone);
				// employeeInfoService.addPhone(homePhone);
			}

			if (employeeInfoForm.getMobilePhoneNumber() != null
					&& employeeInfoForm.getMobilePhoneNumber().length() != 0) {
				Phone mobilePhone = new Phone();
				mobilePhone.setPhoneNumber(employeeInfoForm
						.getMobilePhoneNumber());
				mobilePhone.setPhoneId(employeeInfoForm.getMobilePhoneId());
				mobilePhone.setPhoneType("mobile");
				mobilePhone.setEmployee(employee);
				employee.addPhone(mobilePhone);
				// employeeInfoService.addPhone(mobilePhone);
			}

			employeeInfoService.updateEmployee(employee);

			return mapping.findForward("success");
		} catch (Exception e) {
			return mapping.findForward("fail");
		}
	}
}