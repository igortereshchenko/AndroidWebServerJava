/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query.news;

import model.News;
import org.hibernate.Session;
import query.IQuery;

/**
 *
 * @author student
 */
public class InsertNewsQuery implements IQuery{
    
    
    private News news=null;
    
    public InsertNewsQuery(String title, String content){
        
        this.news = new News(title,content);
    }
    
     public InsertNewsQuery(News news){
        
        this.news = news;
    }
    
     //hibernate
    public Object execute(Session session){
        
        return session.save(news);
    } 
}
