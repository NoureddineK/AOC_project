package diffusion;

import generator.Generator;

public interface Diffusion {

	int GetDiffusionValue();

	void configureDiffusion(Generator generator, int nbObserver);

	void executeDiffusion(Generator generator);
}
