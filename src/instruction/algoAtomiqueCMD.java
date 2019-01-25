package instruction;

import diffusion.AtomiqueDiffusion;
import generator.Generator;

public class algoAtomiqueCMD  implements Instruction {

	private Generator generator;

	public algoAtomiqueCMD(Generator generator ) {
		this.generator = generator;
	}

	@Override
	public void execute() {
		System.out.println("aloAtomiqueCMD:  set diffusion atomique ");
		this.generator.setDiffusion(new AtomiqueDiffusion());
	}

}