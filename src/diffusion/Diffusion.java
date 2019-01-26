package diffusion;

import generator.GeneratorImp;
import observer.ObsGenAsync;

public interface Diffusion {

	Integer getDiffusionValue(ObsGenAsync observerGeneratorAsync, GeneratorImp generator);

	void configureDiffusion(GeneratorImp generator, int nbObserver);

	void executeDiffusion(GeneratorImp generator);
}
