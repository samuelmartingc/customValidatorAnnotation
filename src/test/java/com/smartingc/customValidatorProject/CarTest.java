package com.smartingc.customValidatorProject;



import static org.junit.Assert.*;
import javax.validation.*;
import org.slf4j.*;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import javax.validation.ValidatorFactory;

import org.junit.*;


public class CarTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testLicensePlateNotUpperCase() {

        Car car = new Car("Morris", "dd-ab-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);
        assertEquals(2, constraintViolations.size());
        assertEquals(
              "Case mode must be UPPERCASE.", 
              constraintViolations.iterator().next().getMessage());

          
    }

    @Test
    public void carIsValid() {

        Car car = new Car("Morris", "DD-AB-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);

        assertEquals(0, constraintViolations.size());
    }
}