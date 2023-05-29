package com.chukurnev.sprintbootdemon.validaton;

import com.chukurnev.sprintbootdemon.model.Employee;
import org.apache.commons.lang3.StringUtils;

public class EmployeeValidator {

    public static boolean validate(String firstName, String lastName){
        return (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName));

    }
}
