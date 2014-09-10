package com.jsonstart;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







@SuppressWarnings("serial")
public class JSONstartServlet1 extends HttpServlet implements Serializable {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {		
		String textvald1=req.getParameter("textvald1");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q=(Query) pm.newQuery(ContactBean.class);
		q.declareParameters("String textvald1");
		q.setFilter("ph_No==textvald1");
		List<ContactBean>li=null;
		try {
			li=(List<ContactBean>)q.execute(textvald1);
			for(ContactBean c:li)
			{	
				System.out.print(c.getAddress()+""+c.getAl_Email()+""+c.getEmail()+""+c.getName()+""+c.getPh_No());
				if(c.getPh_No().equalsIgnoreCase(textvald1))
				{
					pm.deletePersistent(c);
					pm.refreshAll();
					resp.getWriter().write("succefully deleted!!!"); 
				}
				else
				{
					resp.getWriter().write("sorry!!");
					
				}
			}
			//ContactBean cb = pm.getObjectById(ContactBean.class,textvald1);
			//System.out.println(cb.getPh_No());
		
			//pm.deletePersistent(cb);
		}
		finally{
			pm.close();
		}
		 resp.setContentType("text/plain");  
		  resp.setCharacterEncoding("UTF-8"); 
		  
	}
}