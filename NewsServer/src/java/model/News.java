/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="news", catalog="dbnews")

public class News implements Serializable{
    
    private int id;
    private String title;
    private String content;
    
    public News(){
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id @GeneratedValue(strategy= IDENTITY)
    @Column(name = "id", unique=true, nullable=false)
    public int getId() {
        return id;
    }
    @Column(name = "title", nullable=false, length = 45)
    public String getTitle() {
        return title;
    }
    @Column(name = "content", nullable=false, length = 45)
    public String getContent() {
        return content;
    }
    
    
}
