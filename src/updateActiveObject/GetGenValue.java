package updateActiveObject;

import java.util.concurrent.Callable;

import generator.Generator;
import observer.ObsGenAsync;

public class GetGenValue implements Callable<Integer> {

	private Generator generator;
	private ObsGenAsync obsGenAsync;
	
	public GetGenValue(Generator generator, ObsGenAsync obsGenAsync) {
		this.generator = generator;
		this.obsGenAsync = obsGenAsync;
	}

	@Override
	public Integer call() throws Exception {
		return generator.getValue();
	}

}