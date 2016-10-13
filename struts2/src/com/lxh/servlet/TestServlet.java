package com.lxh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	          
	        String requestURI=request.getRequestURI();  
	        System.out.println("request="+requestURI);  
	        String path=requestURI.substring(requestURI.indexOf("/",1),requestURI.indexOf("."));  
	        System.out.println("path="+path);  
	          
	        String username=request.getParameter("username");  
	        UserManager userManager=new UserManager();  
	        //userManager.addUser(username);  
	        String forward="";  
	        if("/servlet/delUser".equals(path)){  
	            userManager.delUser(username);  
	            forward="/del_success.jsp";  
	        }else if("/servlet/addUser".equals(path)){  
	            userManager.addUser(username);  
	            forward="/add_success.jsp";  
	        }else if("/servlet/modifyUser".equals(path)){  
	            userManager.modifyUser(username);  
	            forward="/modify_success.jsp";  
	        }else if("/servlet/queryUser".equals(path)){  
	            List userList=userManager.queryUser(username);  
	            request.setAttribute("userList", userList);  
	            forward="/query_success.jsp";  
	        }else{  
	            throw new RuntimeException("«Î«Û ß∞‹");  
	        }  
	        request.getRequestDispatcher(forward).forward(request, response);  
	  
	

}
}
