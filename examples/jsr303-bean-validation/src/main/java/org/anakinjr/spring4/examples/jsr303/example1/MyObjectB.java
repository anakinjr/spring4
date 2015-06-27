package org.anakinjr.spring4.examples.jsr303.example1;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

@StartEndValid
public class MyObjectB {

	@NotNull
	private String name;

	@NotNull
	private LocalDate start;

	@NotNull
	private LocalDate end;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(final LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(final LocalDate end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "MyObjectB[" + name + ",start=" + this.start + ",end=" + this.end + "]";
	}
}
