package diffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import generator.GeneratorImp;
import observer.ObsGenAsync;

public class SequentielDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private List<ObsGenAsync> observers;
	private List<ObsGenAsync> readers;
	private boolean ready;
	private Integer value;

	public SequentielDiffusion() {
		LOGGER.info("Constructor : ");
		value = 0;
		observers = new ArrayList<ObsGenAsync>();
		readers = new ArrayList<ObsGenAsync>();
		ready = true;
	}

	public void setValue(Integer v) {
		LOGGER.info("setValue : " + v);
		value = v;
	}

	@Override
	public Integer getDiffusionValue(ObsGenAsync observerGeneratorAsync, GeneratorImp generator) {
		LOGGER.info("getDiffusionValue : " + this.value);
		return this.value;
	}

	@Override
	public void configureDiffusion(GeneratorImp generator, int nbObserver) {
		LOGGER.info("configureDiffusion : ");

	}

	@Override
	public void executeDiffusion(GeneratorImp generator) {
		LOGGER.info("executeDiffusion : ");
		generator.generateValue();
		if (ready) {
			ready = false;
			value = generator.getValue();
			readers = new ArrayList<>();
			observers = generator.getObserverAsyncs();

			for (ObsGenAsync canal : observers) {
				canal.update(generator);
			}
		}
	}

	public void aReaderReads(ObsGenAsync reader) {
		LOGGER.info("aReaderReads : ");
		if (observers.contains(reader) && !readers.contains(reader)) {
			readers.add(reader);
		}
		if (readers.size() == observers.size()) {
			ready = true;
		}
	}

}
