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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudyServiceTest1 {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
        System.out.println("테스트 성공");
    }

    @Test
    void createStudyService(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
        System.out.println("테스트 성공");
    }

    @Test
    void createStudyService2(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        Optional<Member> optional = memberService.findById(1L);

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
        System.out.println("테스트 성공");
    }

    @Test
    void createStudyService3(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("kwj1270@naver.com", findById.get().getEmail());

        System.out.println("테스트 성공");
    }

    @Test
    void createStudyService4(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        Study study = new Study(10, "java");
        Study newStudy = studyService.createNewStudy(1L, study);

        if(newStudy == null) System.out.println("?");

        assertEquals(1L, study.getOwnerId());
        System.out.println("테스트 성공");

    }


    @Test
    void createStudyService5(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        Optional<Member> findById = memberService.findById(1L);
        Optional<Member> findById_two = memberService.findById(2L);

        assertEquals("kwj1270@naver.com", findById.get().getEmail());
        assertEquals("kwj1270@naver.com", findById_two.get().getEmail());   // 실패

        System.out.println("테스트 성공");

    }

    @Test
    void createStudyService6(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        when(memberService.findById(any())).thenReturn(Optional.of(member));
        Optional<Member> findById = memberService.findById(1L);
        Optional<Member> findById_two = memberService.findById(2L);

        assertEquals("kwj1270@naver.com", findById.get().getEmail());
        assertEquals("kwj1270@naver.com", findById_two.get().getEmail());

        System.out.println("테스트 성공");

    }


    @Test
    void createStudyService7(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        when(memberService.findById(any())).thenReturn(Optional.of(member));
        Optional<Member> findById = memberService.findById(1L);
        Optional<Member> findById_two = memberService.findById(2L);

        assertEquals("kwj1270@naver.com", findById.get().getEmail());
        assertEquals("kwj1270@naver.com", findById_two.get().getEmail());

        when(memberService.findById(1L)).thenThrow(new IllegalArgumentException());
        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertAll(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        memberService.findById(1L);
                    });
                },

                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        memberService.validate(1L);
                    });
                }
        );


        System.out.println("테스트 성공");

    }

    @Test
    void createStudyService8(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("kwj1270@naver.com");

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("kwj1270@naver.com", findById.get().getEmail());

        assertThrows(RuntimeException.class, () -> {
            memberService.findById(2L);
        });

        assertEquals(Optional.empty(), memberService.findById(3L));
        System.out.println("테스트 성공");
    }

}
