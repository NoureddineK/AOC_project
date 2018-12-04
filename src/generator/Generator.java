package generator;

import java.util.concurrent.ExecutionException;
import observer.ObsGenAsync;
import observer.ObserverGenerator;

public interface Generator {

	public void attach(ObserverGenerator o);
	public  void detach(ObserverGenerator o);
	public void attach(ObsGenAsync o);
	public void detach(ObsGenAsync o);
	public void notifyAllObsGenes() throws InterruptedException, ExecutionException;
	public void setValue(int value) throws InterruptedException, ExecutionException;
	public int getValue();

	
	
}
