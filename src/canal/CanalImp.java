package canal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import callable.GetValueCallable;
import callable.MyExecutorService;
import callable.UpdateDisplay;
import callable.UpdatePromise;
import generator.Generator;
import observer.ObserverCanal;
import observer.ObserverGenerator;
import view.Display;

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

	@Override
	public Generator getGenerator() {
		return this.generator;
	}

	@Override
	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	@Override
	public ObserverCanal getDisplay() {
		return this.observerCanal;
	}

	public void setDisplay(ObserverCanal observerCanal) {
		this.observerCanal = observerCanal;
	}

	@Override
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

	@Override
	public void update(Generator generator) {
		LOGGER.info("update Generator: ");
		UpdateDisplay update = new UpdateDisplay(this, (Display) this.observerCanal);
		MyExecutorService.submit(update, DELAY * 100);

	}

	@Override
	public void attach(Object object) {
		LOGGER.info("attach: ");
		this.observerCanal = (ObserverCanal) object;
	}

	@Override
	public void detach(Object object) {
		LOGGER.info("detach: ");
		if (object instanceof ObserverGenerator) {
			observerCanal = null;
		}
	}

	public void update(Promise promise) {
		UpdatePromise updatePromise = new UpdatePromise(promise,
				(Display) observerCanal);
		Future<Integer> future = MyExecutorService.submit(updatePromise, DELAY * 100);
	}

}
