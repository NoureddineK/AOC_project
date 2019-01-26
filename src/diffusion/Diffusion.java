package diffusion;

import generator.Generator;

public interface Diffusion {

	int getDiffusionValue();

	void configureDiffusion(Generator generator, int nbObservers);

	void executeDiffusion();
	
}