package main.diffusion;

import java.util.logging.Logger;

import main.canal.Promise;
import main.generator.Generator;

/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * CausalDiffusion
 */
public class CausalDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;

	public int getDiffusionValue() {
		LOGGER.info("getDiffusionValue : ");
		if (this.generator != null) {
			return this.generator.getDiffusionValue();
		}
		return 0;
	}

	/**
	 * Configure Causal Diffusion
	 * 
	 * @param Generator
	 * @param nomber of Observers
	 */
	public void configureDiffusion(Generator generator, int nbObservers) {
		LOGGER.info("configureDiffusion : ");
		this.generator = generator;
	}

	public void executeDiffusion() {
		LOGGER.info("executeDiffusion : ");
		int value = generator.getDiffusionValue();
		int cycle = generator.getCycleValue();
		Promise promise = new Promise();
		promise.setValue(value);
		promise.setPromiseValue(cycle);
		generator.setValue(value + 1);
		generator.setCycleValue(cycle + 1);
		generator.notifyObservers(promise);

	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}
}
