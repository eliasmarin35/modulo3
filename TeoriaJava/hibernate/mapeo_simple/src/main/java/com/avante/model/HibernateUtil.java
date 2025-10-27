/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author jprof
 */
public class HibernateUtil {
    private static HibernateUtil instance = null;
    
    private SessionFactory factory = null;
    
    private HibernateUtil () {
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    public Session openSession () {
        return this.factory.openSession();
    }
    
    public void shutdown() {
        this.factory.close();
    }
    
    public static HibernateUtil getInstance () {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        
        return instance;
    }
    
    
}
