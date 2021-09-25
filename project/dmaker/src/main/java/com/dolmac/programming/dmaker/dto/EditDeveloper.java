package com.dolmac.programming.dmaker.dto;

import com.dolmac.programming.dmaker.entity.Developer;
import com.dolmac.programming.dmaker.type.DeveloperLevel;
import com.dolmac.programming.dmaker.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EditDeveloper {
    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder
    public static class Request{
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

    }

}
