package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import diffusion.Diffusion;
import observer.ObsGenAsync;
import observer.ObserverGenerator;

public class GeneratorImp implements Generator, Runnable {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	
	private Integer value;
	//private List<ObserverGenerator> observers;
	private List<ObsGenAsync> obsGenAsync;
	private Diffusion diffusion;

	public GeneratorImp(Diffusion diffusion) {
		this.value = 0;
		//this.observers = observers;
		this.obsGenAsync = new ArrayList<>();
		this.diffusion = diffusion;
	}

	@Override
	public void attach(ObsGenAsync o) {
		this.obsGenAsync.add(o);
	}

	@Override
	public void detach(ObsGenAsync o) {
		this.obsGenAsync.remove(o);
	}

	/*@Override
	public void notifyAllObsGenes() throws InterruptedException, ExecutionException {
		for (ObserverGenerator observer : observers) {
			observer.update(this);
		}

		for (ObsGenAsync observer : observersGenAsync) {
			Future<Integer> value = observer.update(this);
			System.out.println(value.get());
		}
	}
*/
	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(int value) throws InterruptedException, ExecutionException {
		this.value = value;
		this.diffusion.executeDiffusion(this);
	}

	@Override
	public void run() {
		while(this.value < 10){

		    try {
		        Thread.sleep(1000);
            } catch (Exception e){}
		    diffusion.executeDiffusion(this);
        }

		
	}

	@Override
	public Integer getValue(ObsGenAsync obs) {
		 return diffusion.getDiffusionValue(obs,this);
	}

	@Override
	public void increment() {
		 this.value++;
	        System.out.println("Generator: " + this.value);	
	}
	 public List<ObsGenAsync> getObserverAsyncs() {
	        return obsGenAsync;
	    }


}
