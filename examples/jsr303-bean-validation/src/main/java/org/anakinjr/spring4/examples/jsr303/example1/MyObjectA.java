package org.anakinjr.spring4.examples.jsr303.example1;

import javax.validation.constraints.NotNull;

public class MyObjectA {

	@NotNull
	private String name;

	@Override
	public String toString() {
		return "MyObjectA[" + name + "]";
	}
}
