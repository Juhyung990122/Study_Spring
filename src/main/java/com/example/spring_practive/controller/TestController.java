package com.example.spring_practive.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TestController {
    // 요청처리시 어떤 컨트롤러가 동작할건지 지정 - url형태로 명시한다
    // 속성들 : value = url / method / 형식값과 변수명(파라미터로 넘겨줄때) / @PathVariable("변수명") / consumes="받아들일 데이터 폼(request body 내 내용) 제한"
    // @RequestMapping("/member/{name}/{age}") -> public String 함수명 (@pathVariable("name"))-> name으로 들어온 값을 매핑
    
    @RequestMapping(value = "/home")
    public String home(){
        return "index.html";
    }

    //view(template)가 아니라 데이터를 반환해야한다면 @Respnesebody
    /*@ResponseBody
    @RequestMapping(value ="/returndata")
    public String returndata(){
        String data = "testdata";
        return data;
    } */ 

    @RequestMapping("/test") 
    public String test(){ 
        return "test"; 
    }

    @RequestMapping("/mv")
    public ModelAndView mvtest(){
        ModelAndView mv = new ModelAndView();
        List<String> listTest = new ArrayList<String>();
        listTest.add("data1");
        listTest.add("data2");
        listTest.add("data3");
        mv.addObject("listTest", listTest); //뷰로 보낼 데이터(변수이름,실제데이터)
        mv.addObject("objecttest", "테스트용오브젝트"); //뷰로 보낼 데이터
        mv.setViewName("mvtest"); //불러올탬플릿
        return mv;
    }
    
 
}   

    

