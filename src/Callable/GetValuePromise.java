package Callable;

import java.util.concurrent.Callable;

import generator.Generator;

public class GetValuePromise implements Callable<Integer> {
	private Generator generator;

	public GetValuePromise(Generator generator) {
		this.generator = generator;
	}

	public Integer call() throws Exception {
		return this.generator.getValue();
	}
}
