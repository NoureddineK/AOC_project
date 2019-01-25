package diffusion;

import generator.Generator;

public interface Diffusion {

	int getDiffusionValue();

	void configureDiffusion(Generator generator, int nbObserver);

	void executeDiffusion();
	
}