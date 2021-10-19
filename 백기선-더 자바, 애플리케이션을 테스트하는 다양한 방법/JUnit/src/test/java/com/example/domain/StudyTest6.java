package com.example.domain;

import com.example.tag.FastTest;
import com.example.tag.SlowTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudyTest6 {

    int value = 0;

    @Order(1)
    @FastTest
    @DisplayName("메인_테스트")
    public void 메인_테스트() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
        System.out.println("\n메인_테스트 실행\n");
    }

    @Order(2)
    @SlowTest
    @DisplayName("서브_테스트")
    public void 서브_테스트() {
        System.out.println("\n서브_테스트 실행\n");
    }

    @Order(3)
    @SlowTest
    @DisplayName("서브_테스트2")
    public void 서브_테스트2() {
        System.out.println("\n서브_테스트2 실행\n");
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
