package com.example.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class StudyTest2 {

    /**
     * .zshrc 수정
     *  export TEST_ENV=LOCAL
     *
     */
    @DisplayName("assumeTrue - assumption의 조건이 맞지 않다면, 테스트를 실패")
    @Test
    public void Study_테스트() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @DisplayName("assumingThat - 조건이 맞지 않아도 테스트를 계속 수행한다.")
    @Test
    public void Study_테스트2() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () ->{
            System.out.println("assumingThat: local");
            Study actual = new Study(100);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

        assumingThat("WOOJAE".equalsIgnoreCase(test_env), () ->{
            System.out.println("assumingThat: woojae");
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

    }

    @EnabledOnOs(OS.MAC)
    @DisplayName("Enabled - ()안에 조건이 맞아야 해당 테스트 메서드를 수행")
    @Test
    public void Study_테스트3() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("EnabledOnOs: do it!!");
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @EnabledOnOs({OS.MAC, OS.LINUX, OS.WINDOWS})
    @DisplayName("EnabledOnOs의 같은 경우는 ()의 값에는 하나가 아닌 여러 멤버들을 넣을 수 있다.")
    @Test
    public void Study_테스트4() {
        System.out.println("EnabledOnOs: do it!!");
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @DisabledOnOs({OS.MAC, OS.LINUX, OS.WINDOWS})
    @DisplayName("()안에 조건이 맞으면 해당 테스트 메서드를 실행시키지 않는다.")
    @Test
    public void Study_테스트6() {
        System.out.println("서브_테스트");
    }

    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11, JRE.JAVA_12, JRE.JAVA_13, JRE.JAVA_14})
    @DisplayName("jre 버전 체크")
    @Test
    public void 서브_테스트() {
        System.out.println("EnabledOnJRE: do it!!");
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @DisabledOnJre(JRE.JAVA_8)
    @DisplayName("() 버전 아닐 때, 실행 가능")
    @Test
    public void 서브_테스트2() {
        System.out.println("서브_테스트");
    }


    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    @DisplayName("환경변수TEST_ENV의 값이 LOCAL이 맞으므로 호출되었다.")
    @Test
    public void 환경변수_체크후_Test() {
        System.out.println("EnabledIfEnvironmentVariable: do it!!");
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    @DisplayName("환경변수TEST_ENV의 값이 LOCAL이 맞으므로 호출되지 않았다.")
    @Test
    public void 환경변수_체크후_Test2() {
        System.out.println("서브_테스트");
    }

}
