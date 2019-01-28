package main.canal;

import main.generator.Generator;
import main.observer.MySubject;
import main.observer.ObserverCanal;
import main.observer.ObserverGenerator;

/**
 * 
 * @author Noureddine KADRI and Fahim MERZOUK
 *
 */
public interface Canal extends ObserverGenerator, MySubject {
	/**
	 * 
	 * @return Generator
	 */
	public Generator getGenerator();

	/**
	 * Set Generator
	 * @param generator
	 */
	public void setGenerator(Generator generator);

	/**
	 * 
	 * @return ObserverCanal
	 */
	public ObserverCanal getDisplay();

	/**
	 *  Update Canal Generator
	 */
	public void update(Generator generator);

	/**
	 *  Return Canal value
	 * @return int
	 */
	public int getValue();

}