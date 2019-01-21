package view;

import java.util.concurrent.Future;
import java.util.logging.Logger;
import generator.GeneratorAsync;
import observer.ObserverGenerator;


public class Afficheur implements ObserverGenerator {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Integer value;
	private int id; 
	
	public Afficheur(int id) {
		this.id = id;
		this.value = 0;
	}

	@Override
	public void update(GeneratorAsync g) throws Exception {
		Future<Integer> future = g.getValue();
		value = future.get();
		System.out.println("Afficheur " + id + " : " + value);
	}

	public Integer getValue() {
		return value;
	}

}
