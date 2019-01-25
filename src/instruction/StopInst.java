package instruction;

import generator.Generator;

public class StopInst implements Instruction  {
	private  Generator generator;
	
	public StopInst( Generator generator) {
		this.generator = generator;
	}
	
	@Override
	public void execute() {
		this.generator.stop();	
	}

}
