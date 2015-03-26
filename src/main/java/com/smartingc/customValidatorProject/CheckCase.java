package com.smartingc.customValidatorProject;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.*;

@Target({METHOD,FIELD,ANNOTATION_TYPE}) // Says, that methods, fields and annotation declarations may be annotated with @CheckCase (but not type declarations e.g.)
@Retention(RUNTIME) //Specifies, that annotations of this type will be available at runtime by the means of reflection
@Constraint(validatedBy = CheckCaseValidator.class) // Specifies the validator to be used to validate elements annotated with @CheckCase
@Documented // Says, that the use of @CheckCase will be contained in the JavaDoc of elements annotated with it
public @interface CheckCase {
	
	 String message() default "default message"; //An attribute message that returns the default key for creating error messages in case the constraint is violated

	    Class<?>[] groups() default {}; //An attribute groups that allows the specification of validation groups, to which this constraint belongs. This must default to an empty array of type Class<?>.

	    Class<? extends Payload>[] payload() default {}; // An attribute payload that can be used by clients of the Bean Validation API to assign custom payload objects to a constraint. This attribute is not used by the API itself.
	    
	    CaseMode value();


}
