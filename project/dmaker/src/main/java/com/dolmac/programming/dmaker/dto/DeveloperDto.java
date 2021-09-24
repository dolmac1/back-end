package com.dolmac.programming.dmaker.dto;

import com.dolmac.programming.dmaker.entity.Developer;
import com.dolmac.programming.dmaker.type.DeveloperLevel;
import com.dolmac.programming.dmaker.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDto {
    private DeveloperSkillType developerSkillType;
    private DeveloperLevel developerLevel;
    private String memberId;

    public static DeveloperDto fromEntity(Developer developer){
        return DeveloperDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType(developer.getDeveloperSkillType())
                .memberId(developer.getMemberId())
                .build();
    }
}
