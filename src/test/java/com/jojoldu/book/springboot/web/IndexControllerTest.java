package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)  // 스프링부트 테스트와 JUnit 사이에 연결자 역할.
// @WebMvcTest: Controller(API) Layer만을 테스트하기 적합한 테스트 어노테이션으로,
// 전체 애플리케이션을 실행하는 것이 아닌 Controller만을 로드하여 테스트를 진행할 수 있는 아주 일목요연한 테스트 방법.
// @SpringBootTest: 실제 애플리케이션을 자신의 로컬 위에 올려서 포트 주소가 Listening되어지고, 실제 DataBase와 커넥션이 붙어지는 상태에서 진행되는 테스트 방법.
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired  // 스프링이 관리하는 빈(Bean)을 주입받는다.
    // TestRestTemplate: MockTesting 과의 차이는 실제 서블릿 컨테이너 실행 여부이며 RestTestTemplate은 컨테이너를 직접 실행한다.
    // 컨테이너: 스프링 컨테이너는 자바 객체의 생명 주기를 관리하며, 생성된 자바 객체들에게 추가적인 기능을 제공하는 역할을 한다.
    // 여기서 말하는 자바 객체를 스프링에서는 빈(Bean)이라고 부른다.
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //when
        // .getForObject: HTTP GET 방식이며, 주어진 URL 주소로 HTTP GET 메서드로 객체로 결과를 반환받는다.
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }

}
