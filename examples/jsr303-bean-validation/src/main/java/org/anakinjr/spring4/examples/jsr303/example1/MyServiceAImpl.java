package org.anakinjr.spring4.examples.jsr303.example1;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Example with explicit validation.
 */
public class MyServiceAImpl implements MyServiceA {

	final static Logger logger = (Logger) LoggerFactory.getLogger(MyServiceAImpl.class);

	/**
	 * injected validator.
	 */
	private Validator validator;

	@Override
	public void doIt(final MyObjectA myObject) {
		logger.info("doIt(" + myObject + ")");
		Set<ConstraintViolation<MyObjectA>> result = validator.validate(myObject);
		logger.info("result:" + result);
		// throw exception, if myobject is not valid
		if (result.size() > 0) {
			throw new IllegalArgumentException("myObject[" + myObject + "] is not valid");
		}
	}

	public void setValidator(final Validator validator) {
		this.validator = validator;
	}

}
