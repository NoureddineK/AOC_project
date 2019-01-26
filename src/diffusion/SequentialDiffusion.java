package diffusion;

import java.util.ArrayList;
import java.util.logging.Logger;

import generator.Generator;
import generator.GeneratorAsync;

public class SequentialDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private int nbObservers = 0;
	private int nbPromiseUpdated = 0;
	private Generator generator;
	private ArrayList<Integer> generatedValues; // Stocker les valeurs generees
	private int valueIndex; // index des valeurs generees

	public SequentialDiffusion() {
		LOGGER.info("Constructor : ");
		generatedValues = new ArrayList<Integer>();
	}

	public void setGenerator(GeneratorAsync generator) {
		LOGGER.info("setValue : ");
		this.generator = generator;
	}

	@Override
	public int getDiffusionValue() {
		LOGGER.info("getDiffusionValue : ");
		nbPromiseUpdated++;
		System.out.println("promises: " + nbPromiseUpdated + "/ Observers" + nbObservers);
		if (valueIndex < generatedValues.size() && valueIndex > -1) {
			return generatedValues.get(valueIndex);
		}
		return 0;
	}

	@Override
	public void configureDiffusion(Generator generator, int nbObservers) {
		LOGGER.info("configureDiffusion : ");
		generatedValues = new ArrayList<Integer>();
		valueIndex = -1;//
		this.generator = generator;
		this.nbObservers = nbObservers;
	}

	@Override
	public void executeDiffusion() {
		LOGGER.info("executeDiffusion : ");
		int generatorValue = generator.getDiffusionValue();
		generatedValues.add(generatorValue);
		this.generator.setValue(generatorValue + 1);

		// Test si il y a des valeurs a afficher 
		if ((valueIndex == -1) || (nbPromiseUpdated >= nbObservers)) {
			valueIndex++;
			nbPromiseUpdated = 0;
			generator.notifyObservers();
		}
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;

	}

}
