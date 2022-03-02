// domain 패키지: 도메인을 담을 패키지.
// 여기서 도메인이란 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사항 혹은 문제 영역을 말한다.
package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //@Getter: 클래스 내의 모든 필드의 Getter 메서드를 자동 생성.(+Entity 클래스에는 절대 Setter 메서드를 만들지 않는다.)
@NoArgsConstructor  //@NoArgsConstructor: 기본 생성자 자동 추가. public Posts() {}와 같은 효과.
@Entity     // @Entity: 테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {
    // Posts 클래스: "실제 DB의 테이블과 매칭될 클래스"이며 보통 Entity 클래스라고도 한다.
    // JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기 보단 이 Entity 클래스의 수정을 통해 작업한다.

    @Id // @Id: 해당 테이블의 PK 필드를 나타낸다.
    // @GeneratedValue: PK의 생성 규칙. GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column: 테이블의 칼럼을 나타냄. 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    //여기서는 문자열이 VARCHER(255)가 기본 값인데 사이즈를 늘리기 위해 사용함.
    @Column(length = 500, nullable = false)
    private String title;

    // 여기서는 타입을 TEXT로 변경하고 싶어 @Column을 사용함.(기본적으로 해당 클래스의 필드는 모두 칼럼이다)
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // @Builder: 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    // Setter가 없는 클래스에서 어떻게 값을 채워 db에 삽입하냐?
    // 생성자를 통해 최종값을 채운 후 db에 삽입하는 것이며, 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메서드를 호출하여 변경한다.
    // 그리고 생성자 대신 @Builder를 통해 제공되는 빌더 클래스를 사용하기 위해 @Builder를 사용함.
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
