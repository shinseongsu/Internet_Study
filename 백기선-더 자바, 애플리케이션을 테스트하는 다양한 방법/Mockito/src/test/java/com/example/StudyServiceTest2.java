package com.example;

import com.example.domain.Member;
import com.example.domain.Study;
import com.example.repository.StudyRepository;
import com.example.service.MemberService;
import com.example.service.StudyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class StudyServiceTest2 {

    @Test
    void createStudyService(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        // When
        studyService.createNewStudy(1L, study);

        // Then
        assertNotNull(studyService);
        assertEquals(member.getId(), study.getOwnerId());

        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);
        verify(memberService, never()).validate(any());
        verifyNoMoreInteractions(memberService);

        System.out.println("테스트 성공");
    }

    @Test
    void createStudyService2(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        Study study = new Study(10, "테스트");

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.createNewStudy(1L, study);

        // Then
        assertNotNull(studyService);
        assertEquals(member.getId(), study.getOwnerId());
        then(memberService).should(times(1)).notify(study);
        then(memberService).should(times(1)).notify(member);
        then(memberService).should(never()).validate(any());
        then(memberService).shouldHaveNoMoreInteractions();

        System.out.println("테스트 성공");
    }

}
