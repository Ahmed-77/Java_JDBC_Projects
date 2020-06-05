package com.CRM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class clientserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private clientDao cliDao;

        public void init() {
        	cliDao = new clientDao();
        }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String cliname = request.getParameter("cliname");
	        String cliaddress = request.getParameter("cliaddress");
	        String clid = request.getParameter("clid");
	        String cliphno = request.getParameter("cliphno");
	        String companyname = request.getParameter("companyname");
	        

	        client CL = new client();
	        CL.setCliname(cliname);
	        CL.setCliaddress(cliaddress);
	        CL.setClid(clid);
	        CL.setCliphno(cliphno);
	        CL.setCompanyname(companyname);
	        

	        try {
	            cliDao.registerclient(CL);
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        }
	    	RequestDispatcher rd = request.getRequestDispatcher("contactserv");
			rd.forward(request, response);
	        PrintWriter out = response.getWriter();
			response.getWriter().append("Served at: ").append(request.getContextPath());
			out.print("Customer Details Entered");
	
	}

}