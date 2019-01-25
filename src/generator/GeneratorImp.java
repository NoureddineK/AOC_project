package generator;

import java.util.ArrayList;
import java.util.logging.Logger;

import canal.CanalImp;
import canal.Promise;
import diffusion.Diffusion;
import instruction.Horloge;
import instruction.OnClick;
import observer.ObserverCanal;
import observer.ObserverGenerator;
import view.Display;

public class GeneratorImp implements Generator {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	private Diffusion diffusion;
	private ArrayList<ObserverGenerator> genObserversList;
	private int generatorValue = 0;
	private Horloge horloge;
	private int _versionEpoq = 0;
	
	public GeneratorImp() {
		LOGGER.info("Constructor: ");
		genObserversList = new ArrayList<ObserverGenerator>();
		OnClick cmdclick = new OnClick(this);
		horloge = new Horloge();
		horloge.activerPeriodiquement(cmdclick, 500);
	}

	@Override
	public int getValue() {
		LOGGER.info("getValue: ");
		return this.diffusion.getDiffusionValue();
	}

	@Override
	public void setValue(int value) {
		LOGGER.info("setValue: ");
		this.generatorValue = value;
	}
	
	@Override
	public Diffusion getDiffusion() {

		return this.diffusion;
	}
	
	public void setDiffusion(Diffusion diffusion) {
		LOGGER.info("setDiffusion: "+ diffusion.getDiffusionValue());
		this.generatorValue = 0;
		this.diffusion = diffusion;
		this.diffusion.configureDiffusion(this, genObserversList.size());

	}

	@Override
	public void notifyObservers() {

		for (ObserverGenerator obs : genObserversList) {
			obs.update(this);
		}
	}

	@Override
	public void executeGenerator() {
		this.diffusion.executeDiffusion();

	}

	@Override
	public void start() {
		horloge.startChrono();

	}

	@Override
	public void stop() {
		horloge.stopChrono();

	}



	@Override
	public int getDiffusionValue() {
		return this.generatorValue;
	}

	@Override
	public void attach(Object o) {
		System.out.println("capteurImp attach o");
		CanalImp can = new CanalImp(this);
		can.setDisplay((Display) o);
		genObserversList.add(can);

	}

	@Override
	public void detach(Object o) {
		genObserversList.remove((ObserverCanal) o);
	}

	public void setHologe(Horloge horloge) {
		this.horloge = horloge;
	}

	@Override
	public int get_versionEpoq() {
		return _versionEpoq;
	}

	@Override
	public void set_versionEpoq(int _versionEpoq) {
		this._versionEpoq = _versionEpoq;
	}

	@Override
	public void notifyObservers(Promise msg) {
		for (ObserverGenerator c : genObserversList) {
			c.update(msg);
		}
	}
}
