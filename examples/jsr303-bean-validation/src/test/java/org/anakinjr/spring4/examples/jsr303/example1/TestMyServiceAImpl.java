package org.anakinjr.spring4.examples.jsr303.example1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/example1/testApplicationContextA.xml")
public class TestMyServiceAImpl {

	@Autowired
	private MyServiceA service;

	@Test
	public void testManualValidation() {
		try {
			service.doIt(new MyObjectA());
			fail("expected illegalargumentexception");
		} catch (IllegalArgumentException iae) {
			assertEquals("myObject[MyObjectA[null]] is not valid", iae.getMessage());
		}
	}
}
