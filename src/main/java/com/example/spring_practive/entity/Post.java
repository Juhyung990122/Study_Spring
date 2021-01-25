package com.example.spring_practive.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String content;

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        if(Id == null){
            if (post.Id != null){
                return false;
            }
        }
        if(content == null){
            if (post.content != null){
                return false;
            }
        }
        if(title == null){
            if (post.title != null){
                return false;
            }
        }
        return true;
    }

}
