/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query.news;

import model.News;
import org.hibernate.Criteria;
import org.hibernate.Session;
import query.IQuery;

/**
 *
 * @author student
 */
public class SelectNewsQuery implements IQuery{
    
    
   
     //hibernate
    public Object execute(Session session){
        
        
        
        Criteria  select = session.createCriteria(News.class);
        return select.list();
    } 
}
