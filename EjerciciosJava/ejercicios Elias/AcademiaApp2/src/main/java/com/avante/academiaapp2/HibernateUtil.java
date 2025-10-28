
package com.avante.academiaapp2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
