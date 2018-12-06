package view;

import java.util.Observable;
import java.util.logging.Logger;

import generator.Generator;
import observer.ObserverGenerator;

public class Afficheur implements ObserverGenerator {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	@Override
	public void update(Generator generator) {
		setGenerator(generator);
	}

	public Integer getValue() {
		return null;
	}


}
