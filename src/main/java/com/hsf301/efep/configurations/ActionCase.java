package com.quynh.efep_hsf.configurations;

import com.quynh.efep_hsf.enums.ActionCaseValues;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface ActionCase {
    ActionCaseValues actionCase() default ActionCaseValues.HOME;
}
