package diffusion;

import java.util.logging.Logger;
import generator.Generator;
import updateActiveObject.Canal;

public class AtomiqueDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Canal canal;

	public AtomiqueDiffusion(Canal canal) {
		LOGGER.info("Constructor : ");
		this.canal = canal;
	}

	@Override
	public void configureDiffusion(Generator generator, int nbObserver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeDiffusion(Generator generator) {
		try {
			canal.update(generator);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	@Override
	public int GetDiffusionValue() {
		// TODO Auto-generated method stub
		return 0;
	}
}
