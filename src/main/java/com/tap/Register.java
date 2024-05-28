package com.tap;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class  Register extends HttpServlet
{
	private static final long serialVersionUID =1L;
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException,NumberFormatException{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		int salary = Integer.parseInt(req.getParameter("salary"));
		Employee e =new Employee(id,name,email,department,salary);
		EmployeeBO bo = new EmployeeBO();
		int i = bo.save(e);
		PrintWriter out  = resp.getWriter();
		if(i==1)
		{
			out.print("Employee saved successfully");
			
		}
		else
		{
			out.print("saving unsuccessfull");
			
		}
		
		
	}
	

}
