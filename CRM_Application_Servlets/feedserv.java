package com.CRM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class feedserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private feedDao feDao;

        public void init() {
        	feDao = new feedDao();
        }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String name = request.getParameter("name");
	        String id = request.getParameter("id");
	        String improv = request.getParameter("improv");
	        String feed = request.getParameter("feed");
	        String rating = request.getParameter("rating");
	        String phno = request.getParameter("phno");
	        

	        Feedback f = new Feedback();
	        f.setName(name);
	        f.setId(id);
	        f.setImprov(improv);
	        f.setFeed(feed);
	        f.setRating(rating);
	        f.setPhno(phno);
	        

	        try {
	            feDao.registerfeed(f);
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        }
	        PrintWriter out = response.getWriter();
			response.getWriter().append("Served at: ").append(request.getContextPath());
			out.print("Feedback Noted");
	
	}

}