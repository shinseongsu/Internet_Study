package com.example;

import com.example.repository.StudyRepository;
import com.example.service.MemberService;
import com.example.service.StudyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudyServiceTest {

    @Test
    void createStudyService() {
        MemberService memberService = mock(MemberService.class);
        StudyRepository studyRepository = mock(StudyRepository.class);
        StudyService studyService = new StudyService(memberService, studyRepository);

        assertNotNull(studyService);
    }

}
