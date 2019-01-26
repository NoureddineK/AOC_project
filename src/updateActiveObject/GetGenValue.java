package updateActiveObject;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import generator.Generator;
import observer.ObsGenAsync;

public class GetGenValue implements Callable<Integer> {

	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;
	private ObsGenAsync obsGenAsync;

	public GetGenValue(Generator generator, ObsGenAsync obsGenAsync) {
		LOGGER.info("Contructor: ");
		this.generator = generator;
		this.obsGenAsync = obsGenAsync;
	}

	@Override
	public Integer call() throws Exception {
		LOGGER.info("call: " + generator.getValue());
		return generator.getValue();
	}

}