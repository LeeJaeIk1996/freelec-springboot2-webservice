package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller // @Controller: "Controller"임을 나타내고, bean으로 등록되며 해당 클래스가 Controller로 사용됨을 Spring Framework에 알린다.
public class IndexController {  // 페이지에 관련된 컨트롤러는 모두 IndexController를 사용하였음.

    private final PostsService postsService;

    // Mustache 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
    // 앞의 경로: src/main/resources/templates , 뒤의 파일 확장자: .mustache
    // 즉 여기선 "index"를 반환하므로, src/main/resources/templates/index.mustache 로 전환되어 View Resolver 가 처리하게 된다.
    // View Resolver: URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격으로 볼 수 있다.
    @GetMapping("/")    // GET 방식은 HTTP 헤더에 값을 담아서 보낸다. 그래서 용량이 제한이 있다.
    public String index(Model model) {  // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        // postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    // /posts/save를 호출하면 posts-save.mustache를 호출하는 메서드
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);

        return "posts-update";
    }
}
