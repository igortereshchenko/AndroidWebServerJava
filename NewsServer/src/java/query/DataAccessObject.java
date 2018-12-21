/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import db.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author student
 */
public class DataAccessObject {
    
    
    public static Object executeQuery(IQuery query){
        
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        
        Session session =  sessionFactory.openSession();
        
        Object result =null;
        
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            
            result = query.execute(session);
            
            transaction.commit();
            
        }catch(Exception e){
            
            if (transaction!=null){
                
                transaction.rollback();
                result=null;
            }
            
        }
        
        
        session.close();
        
        return result;
    }
    
}
