package com.spring.mvc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ServletComponentScan // 서블릿 클래스들을 스캔해서 빈으로 등록 : 스프링기반이라 구기술 사용시 적어준다.
public class WebApplication {

	// 뷰 리졸버 설정 : 컨트롤러가 리턴한 문자열을 해석해주는 객체
	@Bean //@Bean 사용시에는 @Configuration 이 있어야 함 (스프링에는 내장되어있음)
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/"); // prefix: 접두어
		resolver.setSuffix(".jsp"); // suffix: 접미어
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
