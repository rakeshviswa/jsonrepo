package com.jsonstart;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class JSONstartServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	    PrintWriter out=resp.getWriter();
        
        JSONObject json = new JSONObject();
        String textval1=req.getParameter("textval1");
        String textval2=req.getParameter("textval2");
        String textval3=req.getParameter("textval3");
        String textval4=req.getParameter("textval4");
        String textval5=req.getParameter("textval5");       
        ContactBean cb=new ContactBean();
        cb.setName(textval1);
        cb.setPh_No(textval2);
        cb.setEmail(textval3);
        cb.setAl_Email(textval4);
        cb.setAddress(textval5);

        PersistenceManager pm = PMF.get().getPersistenceManager();
         try {
       	  		
                json.put("textval1",cb.getName());
                json.put("textval2",cb.getPh_No());
                json.put("textval3",cb.getEmail());
                json.put("textval4",cb.getAl_Email());
                json.put("textval5",cb.getAddress());            
                pm.makePersistent(cb);              
   	  			pm.refresh(cb);
   	  			pm.refreshAll();
   	  		
       	  		
         } catch (JSONException e) {
                e.printStackTrace();
         }
         finally {
       	  pm.close();
         }
        
         out.print(json);
	}
}
