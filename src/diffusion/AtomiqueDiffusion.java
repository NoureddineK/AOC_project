package diffusion;

import java.util.logging.Logger;

import generator.Generator;

public class AtomiqueDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private int nbObserver = 0;
	private int nbUpdatesReq = 0;
	private boolean updatePossible = true;
	private Generator generator;

	@Override
	public void configureDiffusion(Generator generator, int nbObserver) {
		LOGGER.info("configureDiffusion : ");
		this.nbObserver = nbObserver;
		this.nbUpdatesReq = 0;
		this.generator = generator;
		this.updatePossible = true;
	}

	@Override
	public void executeDiffusion() {
		LOGGER.info("executeDiffusion : ");

		if (updatePossible) {
			updatePossible = false;
			generator.setValue(generator.getDiffusionValue() + 1);
			generator.notifyObservers();

		} else {
			System.out.println("No Click");
		}

	}

	@Override
	public int getDiffusionValue() {
		LOGGER.info("getDiffusionValue : ");
		nbUpdatesReq++;

		if (nbUpdatesReq == nbObserver) {
			updatePossible = true;
			nbUpdatesReq = 0;
		}
		if (this.generator != null)
			return this.generator.getDiffusionValue();
		return 0;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
