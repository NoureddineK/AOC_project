package instruction;

import diffusion.CausalDiffusion;
import generator.Generator;

public class algoEpoqueCMD implements Instruction {

	private Generator generator;

	public algoEpoqueCMD(Generator generator) {
		this.generator = generator;
	}

	@Override
	public void execute() {
		System.out.println("aloSeqCMD:  set CausalDiffusion ");
		generator.setDiffusion(new CausalDiffusion());

	}
}