package com.example.domain;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class StudyTest1 {

    @DisplayName("테스트 실패")
    @Test
    public void Study_테스트() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus());
        System.out.println("Study_테스트");
    }

    @DisplayName("메시지 추가")
    @Test
    public void Study_테스트1() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        System.out.println("Study_테스트");
    }

    @DisplayName("메시지 추가 (람다식)")
    @Test
    public void Study_테스트2() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        System.out.println("Study_테스트");
    }

    @DisplayName("assert All 전 사용 법")
    @Test
    public void Study_테스트3() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 가능 인원은 0보다 커야한다.");
        System.out.println("Study_테스트");
    }

    @DisplayName("assertAll 이용하여 테스트 하기")
    @Test
    public void Study_테스트4() {
        Study study = new Study();
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
                () -> assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 가능 인원은 0보다 커야한다.")
        );
        System.out.println("Study_테스트");
    }

    @DisplayName("assertThrows 사용하기 ")
    @Test
    public void Study_테스트5() {
        assertThrows(IllegalArgumentException.class, () -> new Study(-1));
        System.out.println("Study_테스트");
    }

    @DisplayName("assertThrows 사용하기2")
    @Test
    public void Study_테스트6() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-1));
        String exceptionMessage = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.",exceptionMessage);
        System.out.println("Study_테스트");
    }

    @DisplayName("assertTimeout 실행하는 코드가 특정 시간 이내에 완료되는지 확인")
    @Test
    public void Study_테스트7() {
        assertTimeout(Duration.ofMillis(10), () -> {
            Thread.sleep(300);
            new Study(10);
        });
    }

    @DisplayName("assertTimeoutPreemptively 사용하기")
    @Test
    public void Study_테스트8() {
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            Thread.sleep(300);
            new Study(10);
        });
    }


}
