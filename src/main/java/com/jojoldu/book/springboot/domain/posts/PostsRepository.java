package com.jojoldu.book.springboot.domain.posts;

// Posts클래스로 Database를 접근하게 해주는 JpaRepository.
import org.springframework.data.jpa.repository.JpaRepository;
// 기존에 있던 PostsRepository 인터페이스에 쿼리를 추가.
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 인터페이스(PostsRepository)를 생성한 후, JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD 메서드가 자동으로 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
