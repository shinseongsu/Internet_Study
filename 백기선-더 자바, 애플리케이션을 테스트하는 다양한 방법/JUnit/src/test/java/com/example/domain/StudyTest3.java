package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StudyTest3 {

    @Tag("fast")
    @DisplayName("메_테스트 fast")
    @Test
    public void 메인_테스트() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Tag("slow")
    @DisplayName("서브_테스트 slow")
    @Test
    public void 서브_테스트() throws Exception{
        Thread.sleep(10000);
        System.out.println("서브_테스트");
    }

}
