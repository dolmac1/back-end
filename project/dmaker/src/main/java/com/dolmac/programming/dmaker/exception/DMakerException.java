package com.dolmac.programming.dmaker.exception;

import com.dolmac.programming.dmaker.entity.Developer;
import lombok.Getter;

import java.util.Optional;

@Getter
public class DMakerException extends RuntimeException{
    private DMakerErrorCode dMakerErrorCode;
    private String detailMessage;

    public DMakerException(DMakerErrorCode errorCode){
        super(errorCode.getMessage());
        this.dMakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();

    }

    public  DMakerException(DMakerErrorCode errorCode, String detailMessage){
        super(detailMessage);

        this.dMakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }


}
