package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudyTest4 {

    @RepeatedTest(10)
    void 반복_테스트() {
        System.out.println("test");
    }

    @RepeatedTest(10)
    void 반복_테스트1(RepetitionInfo repetitionInfo) {
        System.out.println("test" + repetitionInfo.getCurrentRepetition()+"/"+repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void 반복_테스트2(RepetitionInfo repetitionInfo) {
        System.out.println("test" + repetitionInfo.getCurrentRepetition()+"/"+repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void ParameterizedTest(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void ParameterizedTest1(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(strings = {"10", "20", "30"})
    void ParameterizedTest2(int number){
        System.out.println("암묵적 형변환 : "+ new Study(number).getLimit());
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(ints = {10, 20, 30})
    void ParameterizedTest(@ConvertWith(StudyConvertor.class) Study study) {
        System.out.println(study.getLimit());
    }

    static class StudyConvertor extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }


//    @ParameterizedTest(name = "{index} {displayName} {0}")
//    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"}, booleans = {true, false, true, false})
//    void ParameterizedTest2(String name, boolean is) {
//        System.out.println(name+is);
//    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void ParameterizedTest(Integer limit, String name){
        System.out.println(new Study(limit, name));
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void ParameterizedTest(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println(study);
    }


    @ParameterizedTest(name = "{index} {displayName} {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void ParameterizedTest2(@AggregateWith(StudyAggregator.class) Study study){
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void ParameterizedTest3(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    @EmptySource
    @NullSource
    void ParameterizedTest4(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    @NullSource
    void ParameterizedTest5(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    @EmptySource
    void ParameterizedTest6(String message) {
        System.out.println(message);
    }

}
