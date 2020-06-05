//Build a web application to maintain a CRM Features
//1.add customers 2.add clients 3.add contact details 4.Customer Features 5.Product and schedule
package com.CRM;
//import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private customerDao custDao;
	private customerDao cusDao;

        public void init() {
        	cusDao = new customerDao();
        }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String cusname = request.getParameter("cusname");
	        String cusaddress = request.getParameter("cusaddress");
	        String cusid = request.getParameter("cusid");
	        String cusphno = request.getParameter("cusphno");
	        String cuscity = request.getParameter("cuscity");
	        

	        customer Cust = new customer();
	        Cust.setCusname(cusname);
	        Cust.setCusaddress(cusaddress);
	        Cust.setCusid(cusid);
	        Cust.setCusphno(cusphno);
	        Cust.setCuscity(cuscity);
	        

	        try {
	            cusDao.registercustomer(Cust);
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        }
		
		//Redirecting to the agreement.jsp to display the agreement details.
		RequestDispatcher rd = request.getRequestDispatcher("clientserv");
		rd.forward(request, response);
		PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		out.print("Customer Details Entered");
	}

}
