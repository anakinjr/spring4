package org.anakinjr.spring4.examples.jsr303.example1;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class StartEndValidator implements ConstraintValidator<StartEndValid, MyObjectB> {

	final static Logger logger = (Logger) LoggerFactory.getLogger(MyServiceAImpl.class);

	@Override
	public void initialize(final StartEndValid constraintAnnotation) {
		logger.info("init(" + constraintAnnotation + ")");
	}

	@Override
	public boolean isValid(final MyObjectB value, final ConstraintValidatorContext context) {
		logger.info("isValid(" + value + "," + context + ")");

		boolean valid = false;
		if (value != null) {
			LocalDate startDate = value.getStart();
			LocalDate endDate = value.getEnd();

			if (startDate != null && endDate != null) {
				valid = endDate.isAfter(startDate);
			}
		}
		return valid;
	}

}