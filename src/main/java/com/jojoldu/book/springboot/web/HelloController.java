// Web 패키지-> 컨트롤러와 관련된 클래스들은 모두 이 패키지에 담음.
package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @RestController: 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
// 예전에는 @ResponseBody를 각 메서드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 된다.
@RestController
public class HelloController {

    // @GetMapping: HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        // @RequestParam: 외부에서 API로 넘김 파라미터를 가져오는 어노테이션.
        // 여기서는 외부에서 name (@RequestParam("name"))이란 이름으로 넘긴 파라미터를
        // 메서드 파라미터 name (String name)에 저장하게 된다.

        // name과 amount는 API를 호출하는 곳에서 넘겨준 값들이다.
        return new HelloResponseDto(name, amount);
    }
}
