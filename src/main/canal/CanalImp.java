package main.canal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import main.callable.GetValueCallable;
import main.callable.MyExecutorService;
import main.callable.UpdateDisplay;
import main.callable.UpdatePromise;
import main.generator.Generator;
import main.observer.ObserverCanal;
import main.view.Display;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 */
public class CanalImp implements Canal {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;
	private ObserverCanal observerCanal;
	private final int MIN = 1;
	private final int MAX = 10;
	private int DELAY = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN;

	public CanalImp(Generator generator) {
		LOGGER.info("Contructor: ");
		this.generator = generator;
	}

	public Generator getGenerator() {
		return this.generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public ObserverCanal getDisplay() {
		return this.observerCanal;
	}

	public void setDisplay(ObserverCanal observerCanal) {
		this.observerCanal = observerCanal;
	}

	public int getValue() {
		GetValueCallable cGetVal = new GetValueCallable(this.generator);
		@SuppressWarnings("unchecked")
		Future<Integer> future = MyExecutorService.submit(cGetVal, DELAY * 100);
		try {
			return future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void update(Generator generator) {
		LOGGER.info("update Generator: ");
		UpdateDisplay update = new UpdateDisplay(this, (Display) this.observerCanal);
		MyExecutorService.submit(update, DELAY * 100);

	}

	public void attach(Object object) {
		LOGGER.info("attach: ");
		this.observerCanal = (ObserverCanal) object;
	}

	public void detach(Object object) {
		LOGGER.info("detach: ");
			observerCanal = null;
	}

	public void update(Promise promise) {
		UpdatePromise updatePromise = new UpdatePromise(promise, (Display) observerCanal);
		Future<Integer> future = MyExecutorService.submit(updatePromise, DELAY * 100);
	}

}
