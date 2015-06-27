package org.anakinjr.spring4.examples.jsr303.example1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface MyServiceB {

	@NotNull(message = "Null returns are not permitted")
	MyObjectC doFirstThing(@NotNull MyObjectB myObject);

	@NotNull(message = "Null returns are not permitted")
	MyObjectC doSecondThing(@StartEndValid MyObjectB myObject);

	@NotNull(message = "Null returns are not permitted")
	MyObjectC doThirdThing(@NotNull @Valid MyObjectB myObject);
}
