package org.anakinjr.spring4.examples.jsr303.example1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.anakinjr.spring4.examples.jsr303.example1.MyObjectB;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class TestMyObjectB {

	final static Logger logger = (Logger) LoggerFactory.getLogger(TestMyObjectB.class);

	@Test
	public void test1() {
		MyObjectB myObjectB = new MyObjectB();
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<MyObjectB>> result = validator.validate(myObjectB);
		logger.info("result:" + result);
		assertThat(4, is(result.size()));
	}

	@Test
	public void test2() {
		MyObjectB myObjectB = new MyObjectB();
		myObjectB.setName("myName");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<MyObjectB>> result = validator.validate(myObjectB);
		logger.info("result:" + result);
		assertThat(3, is(result.size()));
	}

	@Test
	public void test3() {
		MyObjectB myObjectB = new MyObjectB();
		myObjectB.setName("myName");
		myObjectB.setStart(LocalDate.of(2015, 5, 5));
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<MyObjectB>> result = validator.validate(myObjectB);
		logger.info("result:" + result);
		assertThat(2, is(result.size()));
	}

	@Test
	public void test4() {
		MyObjectB myObjectB = new MyObjectB();
		myObjectB.setName("myName");
		myObjectB.setStart(LocalDate.of(2015, 5, 5));

		myObjectB.setEnd(LocalDate.of(2015, 4, 5));
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<MyObjectB>> result = validator.validate(myObjectB);
		logger.info("result:" + result);
		assertThat(1, is(result.size()));
		ConstraintViolation<MyObjectB> violation = result.iterator().next();
		assertNotNull(violation);
		assertThat("{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}", is(violation.getMessage()));
		assertThat("{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}", is(violation.getMessageTemplate()));
	}

	@Test
	public void test5() {
		MyObjectB myObjectB = new MyObjectB();
		myObjectB.setName("myName");
		myObjectB.setStart(LocalDate.of(2015, 5, 5));

		myObjectB.setEnd(LocalDate.of(2015, 6, 5));
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<MyObjectB>> result = validator.validate(myObjectB);
		logger.info("result:" + result);
		assertThat(0, is(result.size()));
	}
}
