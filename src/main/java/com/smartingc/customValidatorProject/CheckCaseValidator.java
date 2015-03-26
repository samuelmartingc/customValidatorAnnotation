package com.smartingc.customValidatorProject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

	 private CaseMode caseMode;

	    public void initialize(CheckCase constraintAnnotation) {
	        this.caseMode = constraintAnnotation.value();
	    }

	    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
	    	constraintContext.disableDefaultConstraintViolation();
	    	constraintContext.buildConstraintViolationWithTemplate("Case mode must be UPPERCASE.").addConstraintViolation();
	        if (object == null)
	            return true;

	        if (caseMode == CaseMode.UPPERCASE)
	            return object.equals(object.toUpperCase());
	        else
	            return object.equals(object.toLowerCase());
	    }

	}