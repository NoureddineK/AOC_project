package instruction;

import generator.Generator;

public class StartInst implements Instruction  {
	private  Generator generator;
	
	public StartInst( Generator generator) {
		this.generator = generator;
	}
	
	@Override
	public void execute() {
		this.generator.start();	
	}

}
