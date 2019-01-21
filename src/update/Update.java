package update;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import generator.Generator;

public class Update implements Callable<Integer> {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	private Generator generator;

	public Update(Generator generator) {
		this.generator = generator;
	}

	@Override
	public Integer call() throws Exception {
		return generator.getValue();
	}
	
	public void GetValueCallable(Generator generator) {
		this.generator = generator;
	}

}
