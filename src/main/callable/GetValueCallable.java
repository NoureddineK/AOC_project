package main.callable;

import java.util.concurrent.Callable;

import main.generator.Generator;
/**
 * 
 * @author Noureddine KADRI  Fahim MERZOUK
 *
 *  Method Invocation: Get Value Callable
 *
 */
public class GetValueCallable implements Callable<Integer> {
	private Generator generator;
/**
 * @param generator
 */
	public GetValueCallable(Generator generator) {
		this.generator = generator;
	}
/**
 * @throws Exception
 * @exception Exception
 * @return Integer 
 */
	public Integer call() throws Exception {
		return this.generator.getValue();
	}
}
