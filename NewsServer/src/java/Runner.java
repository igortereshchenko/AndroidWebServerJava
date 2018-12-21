
import com.google.gson.Gson;
import java.util.List;
import model.News;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import query.DataAccessObject;
import query.IQuery;
import query.news.InsertNewsQuery;
import query.news.SelectNewsQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Runner {
    
    public static void main(String[] args){
        
//        IQuery query1= new InsertNewsQuery("title4", "content4");
//        IQuery query2= new InsertNewsQuery("title5", "content5");
//        IQuery query3= new InsertNewsQuery("title6", "content6");
//        
//        
//        int id1 = (int)DataAccessObject.executeQuery(query1);
//        int id2 = (int)DataAccessObject.executeQuery(query2);
//        int id3 = (int)DataAccessObject.executeQuery(query3);
//        
        
        IQuery select = new SelectNewsQuery();
        List<News> news = (List<News>)DataAccessObject.executeQuery(select);
        
        
        Gson gson = new Gson();
        
        
        String result = gson.toJson(news);
        
        System.out.println(result);
        
        
        
//        System.out.println(id1);
//        System.out.println(id2);
//        System.out.println(id3);
//        
        
        for (News item : news){
             System.out.println(item.getTitle());
             System.out.println(item.getContent());

        }
        
        
    }
}
