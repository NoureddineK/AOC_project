package main.diffusion;

import main.generator.Generator;

/**
 * 
 * @author Noureddine KADRI 
 * @author Fahim MERZOUK
 *
 */
public interface Diffusion {

	/**
	 * 
	 * @return Diffusion value
	 */
	int getDiffusionValue();

	/**
	 * Configure Atomic Diffusion
	 * 
	 * @param Generator
	 * @param nomber of Observers
	 */
	void configureDiffusion(Generator generator, int nbObservers);

	/**
	 * Execute Diffusion, notifyObservers , set Generator Value
	 */
	void executeDiffusion();

}