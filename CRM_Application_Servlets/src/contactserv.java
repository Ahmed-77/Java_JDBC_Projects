package com.CRM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class contactserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private contactDao coDao;

        public void init() {
        	coDao = new contactDao();
        }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String coname = request.getParameter("coname");
	        String coid = request.getParameter("coid");
	        String coemail = request.getParameter("coemail");
	        String cophno = request.getParameter("cophno");
	       
	        

	        contact Co = new contact();
	        Co.setConame(coname);
	        Co.setCoid(coid);
	        Co.setCoemail(coemail);
	        Co.setCophno(cophno);
	        

	        try {
	            coDao.registercontact(Co);
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        }
	    	RequestDispatcher rd = request.getRequestDispatcher("feedserv");
			rd.forward(request, response);
	        PrintWriter out = response.getWriter();
			response.getWriter().append("Served at: ").append(request.getContextPath());
			out.print("Customer Details Entered");
	
	}

}