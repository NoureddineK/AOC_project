package diffusion;

import java.util.logging.Logger;

import generator.Generator;
import generator.GeneratorImp;
import observer.ObsGenAsync;
import updateActiveObject.Canal;

public class CausalDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());


	public CausalDiffusion() {
		LOGGER.info("Constructor : ");
	}


	@Override
	public Integer getDiffusionValue(ObsGenAsync observerGeneratorAsync, GeneratorImp generator) {
		LOGGER.info("getDiffusionValue : ");
		return 0;
	}


	@Override
	public void configureDiffusion(GeneratorImp generator, int nbObserver) {
		LOGGER.info("configureDiffusion : ");
		
	}


	@Override
	public void executeDiffusion(GeneratorImp generator) {
		LOGGER.info("executeDiffusion : ");
		
	}


}
