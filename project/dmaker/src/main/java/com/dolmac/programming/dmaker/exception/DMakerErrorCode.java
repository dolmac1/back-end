package com.dolmac.programming.dmaker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DMakerErrorCode {
    NO_DEVELOPER("해당되는 개발자가 없습니다."),
    DUPLICATED_MEMBER_ID("맴버 아이디가 중복되는 개발자가 있습니다"),
    LEVEL_ERPERIENCE_YEAR_NOT_MATCHED("개발자 레벨과 연차가 맞지 않습니다."),

    INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다"),
    INVELID_REQUEST("잘못된 요청입니다");

    private final String message;
}
