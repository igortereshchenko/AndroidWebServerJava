/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author student
 */
public class HibernateSessionFactory {
    
    private static SessionFactory session= null;
    
    
    private HibernateSessionFactory(){}
    
    public static SessionFactory getSessionFactory(){
        
        if (session ==null){
            
            session = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        
        return session;
    }
    
}
