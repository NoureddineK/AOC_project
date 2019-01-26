package main.diffusion;

import main.generator.Generator;

public interface Diffusion {

	int getDiffusionValue();

	void configureDiffusion(Generator generator, int nbObservers);

	void executeDiffusion();
	
}