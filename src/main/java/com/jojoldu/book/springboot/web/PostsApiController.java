package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    // @RequiredArgsConstructor: 선언된 모든 final 필드가 포함된 "생성자를 생성"해준다.
@RestController // @RestController: 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
public class PostsApiController {

    // @Autowired가 없음. -> 생성자로 Bean을 주입받는 방식을 권장하기때문.
    // 생성자 주입 방식은 final선언이 가능하기때문에 임의로 빈 객체를 변경하는 것을 막을 수 있다.
    private final PostsService postsService;

    // 게시판 등록 기능
    @PostMapping("/api/v1/posts")   // POST방식은 HTTP body에 담아서 보낸다. 등록할때 사용한다.
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // 게시판 수정 기능
    @PutMapping("/api/v1/posts/{id}")   // 수정할때 사용한다. HTTP body에 담아서 보낸다.
    public  Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto); // json의 기본 반환형은 long형
    }

    // 게시판 조회 기능
    @GetMapping("/api/v1/posts/{id}")   // GET 방식은 HTTP 헤더에 값을 담아서 보낸다. 그래서 용량이 제한이 있다.
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 게시판 삭제 기능
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }


}
