package Callable;

import generator.Generator;

public class GetCallableValue {
	private Generator generator;

	public GetCallableValue(Generator generator) {
		this.generator = generator;
	}

	public Integer call() throws Exception {
		return this.generator.getValue();
	}
}
