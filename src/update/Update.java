package update;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import observer.*;
import generator.*;

public class Update implements Callable<Void> {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	private GeneratorAsync generator;
	private List<ObserverGenerator> diffusionList;

	public Update(GeneratorAsync generator, List<ObserverGenerator> diffusionList) {
		this.generator = generator;
		this.diffusionList = diffusionList;
	}

	@Override
	public Void call() throws Exception {
		if (diffusionList.size() > 0) {
			for (ObserverGenerator obsGen : diffusionList) {
				obsGen.update(generator);
			}	
		}
		return null;
	}


}
