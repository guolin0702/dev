package com.e2.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.e2.service.IEmployeeInfoService;
import com.e2.web.form.EmployeeInfoForm;

public class DeleteEmployeeAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			IEmployeeInfoService employeeInfoService = (IEmployeeInfoService) getWebApplicationContext()
					.getBean("employeeInfoService");

			EmployeeInfoForm employeeInfoForm = (EmployeeInfoForm) form;
			long employeeId = employeeInfoForm.getEmployeeId();
			employeeInfoService.deleteEmployee(employeeId);
//
//			long phoneId = employeeInfoForm.getPhoneId();
//			employeeInfoService.deletePhone(phoneId);
//			
			return mapping.findForward("success");
		} catch (Exception e) {
			return mapping.findForward("fail");
		}
	}
}