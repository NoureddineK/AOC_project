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
	private int value;
	
	public SequentielDiffusion() {
		LOGGER.info("Constructor : ");
		value = 0;
		observers = new ArrayList<ObsGenAsync>();
		readers = new ArrayList<ObsGenAsync>();
		ready = true;
	}
	public void setValue(int v) {
		value = v;
	}

	@Override
	public Integer getDiffusionValue(ObsGenAsync observerGeneratorAsync, GeneratorImp generator) {	
		return this.value;
	}

	@Override
	public void configureDiffusion(GeneratorImp generator, int nbObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeDiffusion(GeneratorImp generator) {
		// TODO Auto-generated method stub
		
	}
	public void execute(GeneratorImp g) {
		g.increment();
		if (ready) {
			ready = false;
			value = g.getValue();
			readers = new ArrayList<>();
			observers = g.getObserverAsyncs();

			for (ObsGenAsync channel : observers) {
				channel.update(g);
			}
		}

	}
	public void aReaderReads(ObsGenAsync reader) {
		if (observers.contains(reader) && !readers.contains(reader)) {
			readers.add(reader);
		}
		if (readers.size() == observers.size()) {
			ready = true;
		}
	}
	

}
