package updateActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import generator.Generator;
import generator.GeneratorAsync;
import observer.ObsGenAsync;
import observer.ObserverGenerator;
import update.Update;

public class Canal implements ObsGenAsync, GeneratorAsync {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private ScheduledExecutorService scheduler;// = Executors.newScheduledThreadPool(10);
	private List<ObserverGenerator> diffusionList;
	private Generator generator;
	
	public Canal (ScheduledExecutorService scheduler) {		
		this.scheduler = scheduler;
		this.diffusionList = new ArrayList<ObserverGenerator>();
	}
	
	
	@Override
	public Future<Void> update(Generator generator) {
		LOGGER.info("Calling schedule");
		Update update = new Update(this, diffusionList);
			
			scheduler.schedule(update, 10, TimeUnit.SECONDS);
			this.generator = generator;
			return scheduler.schedule(update, 10, TimeUnit.MILLISECONDS);
		 
	}

	@Override
	public Future<Integer> getValue() {
		GetGenValue getGenValue = new GetGenValue(this.generator,this);
		return scheduler.schedule(getGenValue, 0, TimeUnit.MILLISECONDS);
	}

	@Override
	public void attach(ObserverGenerator obs) {
		diffusionList.add(obs);		
	}

	@Override
	public void detach(ObserverGenerator obs) {
		diffusionList.remove(obs);
	}

}
