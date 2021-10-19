package com.example.domain;

import com.example.tag.FastTest;
import com.example.tag.SlowTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudyTest5 {

    int value = 0;

    @FastTest
    @DisplayName("메인_테스트 fast")
    public void 메인_테스트() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
        System.out.println();
        System.out.println("메인_테스트 실행");
        System.out.println("인스턴스의 해시값 : " + this);
        System.out.println("value = " + ++value);
        System.out.println();
    }

    @SlowTest
    @DisplayName("서브_테스트 slow")
    public void 서브_테스트() {
        System.out.println();
        System.out.println("서브_테스트 실행");
        System.out.println("인스턴스의 해시값 : " + this);
        System.out.println("value = " + ++value);
        System.out.println();
    }

    @BeforeAll
    void BeforeAll_테스트() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void BeforeEach_테스트() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void AfterEach_테스트() {
        System.out.println("AfterEach");
    }

    @AfterAll
    void AfterAll_테스트() {
        System.out.println("AfterAll");
    }

}
