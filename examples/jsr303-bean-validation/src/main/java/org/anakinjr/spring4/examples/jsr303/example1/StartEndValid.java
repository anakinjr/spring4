package org.anakinjr.spring4.examples.jsr303.example1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartEndValidator.class)
@Documented
public @interface StartEndValid {

	String message() default "{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};

}
