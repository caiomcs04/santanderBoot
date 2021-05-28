package com.project.santanderBoot.exceptions;

import com.project.santanderBoot.util.MessageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
