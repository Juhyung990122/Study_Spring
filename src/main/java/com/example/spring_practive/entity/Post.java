package com.example.spring_practive.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="Post")
public class Post {
    //이것이 프라미머리키!
    @Id
    //키값 자동생성전략설정(디폴트는 AUTO) => AUTO_INCREMETN사용했으므로 IDENTITY 사용
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Column으로는 속성값(널허용 유니크...) 설정가능
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
