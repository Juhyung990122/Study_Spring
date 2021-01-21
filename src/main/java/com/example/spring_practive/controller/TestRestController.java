package com.example.spring_practive.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;


//요즘은 @RestController로 위의 Responsebody를 대체한다. Responsebody는 자동으로 활성화
@RestController
public class TestRestController{

    @RequestMapping(value="/returndata",method = RequestMethod.GET)
    public String restTestValue(){
        String restdata = "REST data";
        return restdata;
    }
}

//컨트롤러 두개로 추가하니까 최종결과는 얘가나온다