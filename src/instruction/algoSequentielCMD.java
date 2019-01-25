package instruction;

import diffusion.SequentielDiffusion;
import generator.Generator;

public class algoSequentielCMD implements Instruction {

	private Generator generator;
	
	public algoSequentielCMD(Generator generator) {
		this.generator = generator;
	}

	@Override
	public void execute() {
		System.out.println("aloSeqCMD:  set diffusion sequentielle ");
		generator.setDiffusion(new SequentielDiffusion());
		
	}
}