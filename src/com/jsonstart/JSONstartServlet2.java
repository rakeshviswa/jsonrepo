package com.jsonstart;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.Gson;


public class JSONstartServlet2 extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {		
		String textvals1=req.getParameter("textvals1");
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query q=(Query) pm.newQuery(ContactBean.class);
		q.declareParameters("String textvals1");
		q.setFilter("name==textvals1");
		
		 //HttpSession session=req.getSession();
		 List<ContactBean> results=null;
		 String json=null;
	try{
		
		results=(List<ContactBean>)q.execute(textvals1);
		//results = (List<ContactBean>) pm.detachCopyAll(results);
		
		if(results.isEmpty())
		{	
			
			System.out.println("empty");
			resp.getWriter().write("sorry"); 
		}
		else
		{	
			
			System.out.println("not empty");
			
			json=new Gson().toJson(results);
			resp.getWriter().write(json); 
			
			
		}

	}catch(Exception e){
		System.out.println("exception catched"+e);
	}
	finally{
		q.closeAll();
		pm.close();
		}
	 resp.setContentType("application/json");
     resp.setCharacterEncoding("UTF-8");
   
	}
}
