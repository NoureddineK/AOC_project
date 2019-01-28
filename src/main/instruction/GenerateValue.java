package main.instruction;

import main.generator.Generator;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 */
public class GenerateValue{

	private Generator generator;
	
	public GenerateValue(Generator generator) {
		this.generator = generator;
	}
	
	public void execute() {
		this.generator.executeGenerator();	
	}

}
