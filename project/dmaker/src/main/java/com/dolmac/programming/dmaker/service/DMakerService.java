package com.dolmac.programming.dmaker.service;

import com.dolmac.programming.dmaker.dto.CreateDeveloper;
import com.dolmac.programming.dmaker.dto.DeveloperDetailDto;
import com.dolmac.programming.dmaker.dto.DeveloperDto;
import com.dolmac.programming.dmaker.entity.Developer;
import com.dolmac.programming.dmaker.exception.DMakerErrorCode;
import com.dolmac.programming.dmaker.exception.DMakerException;
import com.dolmac.programming.dmaker.repository.DeveloperRepository;
import com.dolmac.programming.dmaker.type.DeveloperLevel;
import com.dolmac.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request){
        validateCreateDeveloperRequest(request); // 벨리데이션 체크

        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYear(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();
        developerRepository.save(developer);
        return CreateDeveloper.Response.fromEntity(developer);// response를 손쉽게 생성하여 전송
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
//비즈니스 밸리데이션 체크
        if(request.getDeveloperLevel() == DeveloperLevel.SINIOR
                && request.getExperienceYears() < 10){
            throw new DMakerException(DMakerErrorCode.LEVEL_ERPERIENCE_YEAR_NOT_MATCHED);//ALT + ENTER 눌러서 STATIC IMPORT해서 사용도 가능
        }
        if(request.getDeveloperLevel() == DeveloperLevel.JUNGNIOR
                &&(request.getExperienceYears() <3 || request.getExperienceYears() > 10)){
            throw new DMakerException(DMakerErrorCode.LEVEL_ERPERIENCE_YEAR_NOT_MATCHED);
        }
        if(request.getDeveloperLevel() == DeveloperLevel.JUNIOR && request.getExperienceYears() > 4){
            throw new DMakerException(DMakerErrorCode.LEVEL_ERPERIENCE_YEAR_NOT_MATCHED);
        }
        developerRepository.findByMemberId(request.getMemberId()).ifPresent((developer -> {throw new DMakerException(DMakerErrorCode.DUPLICATED_MEMBER_ID);}));

    }

    public List<DeveloperDto> getAllDevelopers() {
        return developerRepository.findAll()
                .stream().map(DeveloperDto::fromEntity)
                .collect(Collectors.toList());//우리가 원하는 타입으로 모든 데이터를 받아옴
    }

    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId)
                .map(DeveloperDetailDto::fromEntity).orElseThrow(() -> new DMakerException(DMakerErrorCode.NO_DEVELOPER));
    }
}
