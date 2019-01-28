package main.generator;

import main.canal.Promise;
import main.diffusion.Diffusion;
import main.observer.MySubject;

/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 */
public interface Generator extends MySubject {

	/**
	 * Get Generator Value
	 * 
	 * @return int
	 */
	public int getValue();

	/**
	 * Set Generator Value
	 * 
	 * @param value
	 * @return void
	 */
	public void setValue(int value);

	/**
	 * Execute Generator Diffusion
	 * 
	 * @return void
	 */
	public void executeGenerator();

	/**
	 * Start Diffusion
	 */
	public void start();

	/**
	 * Stop Diffusion
	 */
	public void stop();

	/**
	 * Notify All Observers
	 */
	public void notifyObservers();

	/**
	 * Get Generator Diffusion
	 * 
	 * @return Diffusion
	 */
	public Diffusion getDiffusion();

	/**
	 * Set Generator Diffusion
	 * 
	 * @param diffusion
	 */
	public void setDiffusion(Diffusion diffusion);

	/**
	 * return Generator Diffusion Value
	 * 
	 * @return int
	 */
	public int getDiffusionValue();

	/**
	 * Get Cycle Value, Used for Causal Diffusion
	 * 
	 * @return int
	 */
	public int getCycleValue();

	/**
	 * Set Cycle Value, Used for Causal Diffusion
	 * 
	 * @param value
	 */
	public void setCycleValue(int value);

	/**
	 * Notify Observers of Promise in Causal Diffusion
	 * 
	 * @param promise
	 */
	public void notifyObservers(Promise promise);

}
