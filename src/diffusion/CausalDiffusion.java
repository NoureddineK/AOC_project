package diffusion;

import java.util.logging.Logger;

import canal.Promise;
import generator.Generator;

public class CausalDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;

	@Override
	public int getDiffusionValue() {
		LOGGER.info("getDiffusionValue : ");
		if (this.generator != null) {
			return this.generator.getDiffusionValue();
		}
		return 0;
	}

	@Override
	public void configureDiffusion(Generator generator, int nbObservers) {
		LOGGER.info("configureDiffusion : ");
		this.generator = generator;
	}

	@Override
	public void executeDiffusion() {
		LOGGER.info("executeDiffusion : ");
		int val = generator.getDiffusionValue();
		int ver_epo = generator.get_versionEpoq();
		Promise epmsg = new Promise();
		epmsg.set_value(val);
		epmsg.set_versionNumber(ver_epo);
		generator.setValue(val + 1);
		generator.set_versionEpoq(ver_epo + 1);
		generator.notifyObservers(epmsg);

	}

	public void setGenerator(Generator generator) {
		this.generator = generator;

	}

}
