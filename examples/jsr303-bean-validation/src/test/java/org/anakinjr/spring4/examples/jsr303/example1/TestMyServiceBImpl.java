package org.anakinjr.spring4.examples.jsr303.example1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/example1/testApplicationContextB.xml")
public class TestMyServiceBImpl {

	@Autowired
	private MyServiceB service;

	@Test
	public void testDoFirstThingParameterIsNullViolation() {

		try {
			service.doFirstThing(null);
			fail("exception expected");
		} catch (MethodConstraintViolationException cve) {
			Set<MethodConstraintViolation<?>> violations = cve.getConstraintViolations();
			assertNotNull(violations);
			assertThat(1, is(violations.size()));
			ConstraintViolation<?> violation = violations.iterator().next();
			assertNotNull(violation);
			assertThat("should not be null", is(violation.getMessage()));
			assertThat("{javax.validation.constraints.NotNull.message}", is(violation.getMessageTemplate()));

		}
	}

	@Test
	public void testDoSecondThingParameterIsNullViolation() {

		try {
			service.doSecondThing(null);
			fail("exception expected");
		} catch (MethodConstraintViolationException cve) {
			Set<MethodConstraintViolation<?>> violations = cve.getConstraintViolations();
			assertNotNull(violations);
			assertThat(1, is(violations.size()));
			ConstraintViolation<?> violation = violations.iterator().next();
			assertNotNull(violation);
			assertThat("{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}", is(violation.getMessage()));
			assertThat("{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}",
					is(violation.getMessageTemplate()));

		}
	}

	@Test
	public void testDoThirdThingParameterIsNullViolation() {

		try {
			service.doThirdThing(null);
			fail("exception expected");
		} catch (MethodConstraintViolationException cve) {
			Set<MethodConstraintViolation<?>> violations = cve.getConstraintViolations();
			assertNotNull(violations);
			assertThat(1, is(violations.size()));
			ConstraintViolation<?> violation = violations.iterator().next();
			assertNotNull(violation);
			assertThat("should not be null", is(violation.getMessage()));
			assertThat("{javax.validation.constraints.NotNull.message}", is(violation.getMessageTemplate()));

		}
	}

	@Test
	public void testDoThirdThingParameterNotNullViolation() {

		try {
			MyObjectB myObjectB = new MyObjectB();
			service.doThirdThing(myObjectB);
			fail("exception expected");
		} catch (MethodConstraintViolationException cve) {
			Set<MethodConstraintViolation<?>> violations = cve.getConstraintViolations();
			assertNotNull(violations);
			assertThat(4, is(violations.size()));
		}
	}

	@Test
	public void testDoThirdThingParameterConstraintViolation() {

		try {
			MyObjectB myObjectB = new MyObjectB();
			myObjectB.setName("myName");
			myObjectB.setStart(LocalDate.of(2015, 5, 6));
			myObjectB.setEnd(LocalDate.of(2015, 4, 6));
			service.doThirdThing(myObjectB);
			fail("exception expected");
		} catch (MethodConstraintViolationException cve) {
			Set<MethodConstraintViolation<?>> violations = cve.getConstraintViolations();
			assertNotNull(violations);
			assertThat(1, is(violations.size()));
			ConstraintViolation<?> violation = violations.iterator().next();
			assertNotNull(violation);
			assertThat("{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}", is(violation.getMessage()));
			assertThat("{org.anakinjr.spring4.examples.jsr303.example2.startendvalid}",
					is(violation.getMessageTemplate()));
		}
	}

	@Test
	public void testDoThirdThingParameterResultViolation() {

		try {
			MyObjectB myObjectB = new MyObjectB();
			myObjectB.setName("empty");
			myObjectB.setStart(LocalDate.of(2015, 5, 6));
			myObjectB.setEnd(LocalDate.of(2015, 6, 6));
			service.doThirdThing(myObjectB);
			fail("exception expected");
		} catch (MethodConstraintViolationException cve) {
			Set<MethodConstraintViolation<?>> violations = cve.getConstraintViolations();
			assertNotNull(violations);
			assertThat(1, is(violations.size()));
			ConstraintViolation<?> violation = violations.iterator().next();
			assertNotNull(violation);
			assertThat("Null returns are not permitted", is(violation.getMessage()));
			assertThat("Null returns are not permitted", is(violation.getMessageTemplate()));
		}
	}

	@Test
	public void testDoThirdThingGreen() {

		try {
			MyObjectB myObjectB = new MyObjectB();
			myObjectB.setName("myName");
			myObjectB.setStart(LocalDate.of(2015, 5, 6));
			myObjectB.setEnd(LocalDate.of(2015, 6, 6));
			service.doThirdThing(myObjectB);

		} catch (MethodConstraintViolationException cve) {
			fail("exception expected");
		}
	}
}
