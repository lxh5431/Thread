package com.lxh.servlet;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
	   public void addUser(String username){  
	        System.out.println("UserManager.addUsre()--->username:"+username);  
	    }  
	      
	    public void delUser(String username){  
	        System.out.println("UserManager.delUser()--->username:"+username);  
	    }  
	      
	    public void modifyUser(String username){  
	        System.out.println("UserManager.modifyUser()--->username"+username);  
	    }  
	      
	    public List queryUser(String username){  
	        System.out.println("UserManager.queryUser()--->username"+username);  
	        List userList=new ArrayList();  
	        userList.add("a");  
	        userList.add("b");  
	        userList.add("c");  
	        return userList;  
	    }  

}
