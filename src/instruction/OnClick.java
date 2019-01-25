package instruction;

import generator.Generator;

public class OnClick implements Instruction{

	private Generator generator;
	
	public OnClick(Generator generator) {
		this.generator = generator;
	}
	
	@Override
	public void execute() {
		this.generator.executeGenerator();	
	}

}
