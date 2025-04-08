package com.a5a5lab.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.a5a5lab.common.interceptor.CheckLoginSessionInterceptor;
//자동으로 함수를 시랭시ㅕ라
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//		.order(1)
		.addPathPatterns("/*Xdm*" , "/*/*Xdm*","/*xdm*","/*Pda*")
		.excludePathPatterns(
//				
				// 관리자 로그인하기전에 로그인 폼만 보여주고 나머지 XX
				"/*Xdm*/",
				"/*xdm*",
			
				"/SigninAdimn", // 관리자 로그인화면
				"/SigninAdimn1", // 관리 로그인 동작
				//pda
				"/SigninPda", //pda 로그인화면
				"/SigninPdaProc" // pda 로그인아작스
				
				
		);
	
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
