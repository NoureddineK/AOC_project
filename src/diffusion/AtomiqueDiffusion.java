package diffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import generator.Generator;
import generator.GeneratorImp;
import observer.ObsGenAsync;
import updateActiveObject.Canal;

public class AtomiqueDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private List<ObsGenAsync> observers;
	private boolean read;

	public AtomiqueDiffusion() {
		LOGGER.info("Constructor : ");
		this.observers = new ArrayList<>();
		this.read = true;
	}

	@Override
	public void configureDiffusion(GeneratorImp generator, int nbObserver) {
		LOGGER.info("configureDiffusion : ");
		// TODO Auto-generated method stub

	}

	@Override
	public void executeDiffusion(GeneratorImp generator) {
		LOGGER.info("executeDiffusion : ");
		if (this.read) {
			generator.generateValue();
			for (ObsGenAsync canal : generator.getObserverAsyncs()) {
				canal.update(generator);
			}
			this.read = false;
			this.observers.removeAll(this.observers);
		}

	}

	@Override
	public Integer getDiffusionValue(ObsGenAsync obsGenAsync, GeneratorImp generator) {
		LOGGER.info("getDiffusionValue : ");
		if (!this.observers.contains(obsGenAsync)) {
			this.observers.add(obsGenAsync);
			if (this.observers.size() == generator.getObserverAsyncs().size()) {
				this.read = true;
			}
		}

		return generator.getValue();
	}
}
