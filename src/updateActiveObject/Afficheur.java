package updateActiveObject;

import generator.Generator;
import observer.ObserverGenerator;

public class Afficheur implements ObserverGenerator {

	private Generator generator;

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	@Override
	public void update(Generator generator) {
		
	}

}
