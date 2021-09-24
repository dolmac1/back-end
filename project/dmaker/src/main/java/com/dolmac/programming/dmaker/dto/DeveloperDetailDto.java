package com.dolmac.programming.dmaker.dto;

import com.dolmac.programming.dmaker.entity.Developer;
import com.dolmac.programming.dmaker.type.DeveloperLevel;
import com.dolmac.programming.dmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private Integer experienceYear;
    private String memberId;
    private String name;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public static DeveloperDetailDto fromEntity(Developer developer){
        return DeveloperDetailDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType(developer.getDeveloperSkillType())
                .experienceYear(developer.getExperienceYear())
                .memberId(developer.getMemberId())
                .name(developer.getName())
                .age(developer.getAge())
                .createdAt(developer.getCreatedAt())
                .updatedAt(developer.getUpdatedAt())
                .build();
    }
}
