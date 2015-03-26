package com.smartingc.customValidatorProject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements
		ConstraintValidator<CheckCase, String> {

	private CaseMode caseMode;

	public void initialize(CheckCase constraintAnnotation) {
		this.caseMode = constraintAnnotation.value();
	}

	public boolean isValid(String object,
			ConstraintValidatorContext constraintContext) {
		if (object == null)
			return true;

		if (caseMode == CaseMode.UPPERCASE) {
			if (object.equals(object.toUpperCase())) {
				return true;
			} else {
				changeToCustomMessage(constraintContext, "UPPERCASE");
				return false;
			}
		} else {
			if (object.equals(object.toUpperCase())) {
				return true;
			} else {
				changeToCustomMessage(constraintContext, "LOWERCASE");
				return false;
			}
		}
	}

	private void changeToCustomMessage(
			ConstraintValidatorContext constraintContext, String ulCase) {
		constraintContext.disableDefaultConstraintViolation();
		constraintContext.buildConstraintViolationWithTemplate(
				"Case mode must be " + ulCase + ".")
				.addConstraintViolation();
	}
}