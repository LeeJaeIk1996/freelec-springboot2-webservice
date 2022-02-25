package com.jojoldu.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBootApplication: 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 -> autoconfigure = 자동 구성
@SpringBootApplication
public class Application {  // Application class: 앞으로 만들 프로젝트의 메인 클래스
    // 특히 SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다.
    public static void main(String[] args) {
        // SpringApplication.run 으로 인해 내장 WAS를 실행한다.
        SpringApplication.run(Application.class, args);
    }
}
