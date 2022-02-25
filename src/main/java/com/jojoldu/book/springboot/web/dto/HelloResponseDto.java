package com.jojoldu.book.springboot.web.dto;

// lombok: 자바 개발할 때 자주 사용하는 코드 Getter, Setter, 기본 생성자, toString 등을 어노테이션으로 자동 생성해준다.
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// @Getter: 선언된 모든 필드의 "get 메서드를 생성"해 준다.
@Getter
// @RequiredArgsConstructor: 선언된 모든 final 필드가 포함된 "생성자를 생성"해준다.
// final이 없는 필드는 생성자에 포함되지 않는다.
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
