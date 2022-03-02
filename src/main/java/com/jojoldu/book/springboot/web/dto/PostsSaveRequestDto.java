package com.jojoldu.book.springboot.web.dto;
/**
 * dto클래스는 Entity클래스(Posts.java)와 유사한 형태임에도 생성하였다.
 * 왜냐하면 Entity클래스를 Request/Response 클래스로 사용하면 안되기 때문이다.
 * Entity클래스는 데이터베이스와 맞닿은 핵심 클래스이다.
 * 즉, 수많은 서비스 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작하여 Entity 클래스가 변경되면 여러 클래스에 영향을 끼치지만,
 * Request와 Response용 Dto는 View를 위한 클래스라 정말 자주 변경이 필요하다.
 */

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
