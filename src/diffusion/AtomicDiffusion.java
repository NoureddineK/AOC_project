package diffusion;

import java.util.logging.Logger;

import generator.Generator;

public class AtomicDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private int nbObservers = 0;
	private int nbPromiseUpdated = 0;
	private boolean canUpdate = true;
	private Generator generator;

	@Override
	public void configureDiffusion(Generator generator, int nbObservers) {
		LOGGER.info("configureDiffusion : ");
		this.nbObservers = nbObservers;
		this.nbPromiseUpdated = 0;
		this.generator = generator;
		this.canUpdate = true;
	}

	@Override
	public void executeDiffusion() {
		LOGGER.info("executeDiffusion : ");
		if (canUpdate) {
			canUpdate = false;
			generator.setValue(generator.getDiffusionValue() + 1);
			generator.notifyObservers();

		} else {
			System.out.println("Cannot Update");
		}
	}

	@Override
	public int getDiffusionValue() {
		LOGGER.info("getDiffusionValue : ");
		nbPromiseUpdated++;

		if (nbPromiseUpdated == nbObservers) {
			canUpdate = true;
			nbPromiseUpdated = 0;
		}
		if (this.generator != null)
			return this.generator.getDiffusionValue();
		return 0;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
