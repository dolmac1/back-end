package com.dolmac.programming.dmaker.service;

import com.dolmac.programming.dmaker.entity.Developer;
import com.dolmac.programming.dmaker.repository.DeveloperRepository;
import com.dolmac.programming.dmaker.type.DeveloperLevel;
import com.dolmac.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(){
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.BACKEND)
                .experienceYear(2)
                .name("Chovy")
                .age(27)
                .build();
        developerRepository.save(developer);
    }
}
