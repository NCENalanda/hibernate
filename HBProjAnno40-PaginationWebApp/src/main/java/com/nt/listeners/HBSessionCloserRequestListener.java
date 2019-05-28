package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class HBSessionCloserRequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public HBSessionCloserRequestListener() {
    	System.out.println("HBSessionCloserRequstListener()");
    }

    public void requestDestroyed(ServletRequestEvent sre)  {
    	System.out.println("HBSessionClonserRequestListenr::requestDestroyed(-)");
    	//close HB session 
    	HibernateUtil.closeSession();
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    }
	
}
