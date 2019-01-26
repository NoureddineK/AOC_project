package instruction;

import generator.Generator;

public class GenerateValue{

	private Generator generator;
	
	public GenerateValue(Generator generator) {
		this.generator = generator;
	}
	
	public void execute() {
		this.generator.executeGenerator();	
	}

}