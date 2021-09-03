package com.dolmac.programming.dmaker.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperSkillType {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    FULL("풀스택");

    private final String description;
}
