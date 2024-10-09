package com.ra.demo_validation.validation.annotation;

import com.ra.demo_validation.validation.handle.HandleNameExist;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleNameExist.class)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameExist
{
    String message() default "name already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
