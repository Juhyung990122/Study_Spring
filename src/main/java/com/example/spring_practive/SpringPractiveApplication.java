package com.example.spring_practive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration + @ComponentScan + @Configuration
//@SpringBootApplication 을 선언한 클래스가 있는 패키지를 최상위 패키지로 인식 -> 이후 컴포넌트 스캔

@SpringBootApplication
public class SpringPractiveApplication {
	//스프링 서버 구동을 위한 main method
	public static void main(String[] args) {
		SpringApplication.run(SpringPractiveApplication.class, args);
	}

}
