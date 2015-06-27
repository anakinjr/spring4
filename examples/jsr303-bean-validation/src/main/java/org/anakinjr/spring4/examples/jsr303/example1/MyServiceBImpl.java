package org.anakinjr.spring4.examples.jsr303.example1;

import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import ch.qos.logback.classic.Logger;

/**
 * Example with implicit ({@link MethodValidationPostProcessor}) validation.
 */
@Validated
public class MyServiceBImpl implements MyServiceB {

	final static Logger logger = (Logger) LoggerFactory.getLogger(MyServiceBImpl.class);

	@Override
	public MyObjectC doFirstThing(final MyObjectB myObject) {
		logger.info("doFirstThing(" + myObject + ")");

		return new MyObjectC();
	}

	@Override
	public MyObjectC doSecondThing(final MyObjectB myObject) {
		logger.info("doSecondThing(" + myObject + ")");

		return new MyObjectC();
	}

	@Override
	public MyObjectC doThirdThing(final MyObjectB myObject) {
		logger.info("doThirdThing(" + myObject + ")");
		MyObjectC result = null;

		// fake null result if name == empty
		if (!"empty".equals(myObject.getName())) {
			result = new MyObjectC();
		}
		return result;
	}

}
