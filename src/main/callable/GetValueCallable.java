package main.callable;

import java.util.concurrent.Callable;

import main.generator.Generator;

public class GetValueCallable implements Callable<Integer> {
	private Generator generator;

	public GetValueCallable(Generator generator) {
		this.generator = generator;
	}

	public Integer call() throws Exception {
		return this.generator.getValue();
	}
}
