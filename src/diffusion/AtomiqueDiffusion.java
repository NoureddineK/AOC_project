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
	private List<ObsGenAsync> readers;
	private boolean read;

	public AtomiqueDiffusion() {
		LOGGER.info("Constructor : ");
		this.readers = new ArrayList<>();
		this.read = true;
	}

	@Override
	public void configureDiffusion(GeneratorImp generator, int nbObserver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeDiffusion(GeneratorImp generator) {
		if (this.read) {
			generator.increment();
			for (ObsGenAsync canal : generator.getObserverAsyncs()) {
				canal.update(generator);
			}
			this.read = false;
			this.readers.removeAll(this.readers);
		}

	}

	@Override
	public Integer getDiffusionValue(ObsGenAsync obsGenAsync, GeneratorImp generator) {
		if (!this.readers.contains(obsGenAsync)) {
			this.readers.add(obsGenAsync);
			if (this.readers.size() == generator.getObserverAsyncs().size()) {
				this.read = true;
			}
		}

		return generator.getValue();
	}
}
