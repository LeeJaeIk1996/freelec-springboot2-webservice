package com.jojoldu.book.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)  // // 스프링부트 테스트와 JUnit 사이에 연결자 역할.
@SpringBootTest // 별다른 설정 없이 @SpringBootTest를 실행할 경우 H2데이터베이스를 자동으로 실행해준다.
public class PostsRepositoryTest {

    @Autowired   // 스프링이 관리하는 빈(Bean)을 주입받는다.
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 개시글";
        String content = "테스트 본문";

        // postsRepository.save: 테이블 posts에 insert/update 쿼리를 실행. id값이 있다면 update가, 없다면 insert 쿼리를 실행.
        // 쿼리(Query)란 쉽게 이야기해서 데이터베이스에 정보를 요청하는 것입니다.
        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("jojoldu@gmail.com")
                        .build());

        //when
        // postsRepository.findAll: 테이블 posts에 있는 모든 데이터를 조회해오는 메서드.
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2022,3,2,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> creatDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
