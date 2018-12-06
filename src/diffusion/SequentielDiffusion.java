package diffusion;

import java.util.logging.Logger;

import generator.Generator;
import updateActiveObject.Canal;

public class SequentielDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Canal canal;

	public SequentielDiffusion(Canal canal) {
		LOGGER.info("Constructor : ");
		this.canal = canal;
	}

	@Override
	public void configureDiffusion(Generator generator, int nbObserver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeDiffusion(Generator g) {
		// TODO Auto-generated method stub

	}

	@Override
	public int GetDiffusionValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
