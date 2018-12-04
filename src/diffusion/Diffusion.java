package diffusion;

import generator.Generator;

public interface Diffusion {
	void configure();

	void execute(Generator g);
}
