package generator;

import java.util.ArrayList;
import java.util.logging.Logger;

import canal.CanalImp;
import canal.Promise;
import diffusion.Diffusion;
import instruction.DisplayController;
import instruction.GenerateValue;
import observer.ObserverCanal;
import observer.ObserverGenerator;
import view.Display;

public class GeneratorAsync implements Generator {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	private Diffusion diffusion;
	private ArrayList<ObserverGenerator> genObserversList;
	private int generatorValue = 0;
	private DisplayController controller;
	private int cycleValue = 0;
	
	public GeneratorAsync() {
		LOGGER.info("Constructor: ");
		genObserversList = new ArrayList<ObserverGenerator>();
		GenerateValue generateValue = new GenerateValue(this);
		controller = new DisplayController();
		controller.activeCycle(generateValue, 500);
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
		LOGGER.info("setDiffusion");
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
		controller.startDisplaying();
	}

	@Override
	public void stop() {
		controller.stopDisplaying();
	}

	@Override
	public int getDiffusionValue() {
		return this.generatorValue;
	}

	@Override
	public void attach(Object o) {
		CanalImp canal = new CanalImp(this);
		canal.setDisplay((Display) o);
		genObserversList.add(canal);
	}

	@Override
	public void detach(Object o) {
		genObserversList.remove((ObserverCanal) o);
	}

	public void setHologe(DisplayController displayController) {
		this.controller = displayController;
	}

	@Override
	public int getCycleValue() {
		return cycleValue;
	}

	@Override
	public void setCycleValue(int cycleValue) {
		this.cycleValue = cycleValue;
	}

	@Override
	public void notifyObservers(Promise promise) {
		for (ObserverGenerator observerGenerator : genObserversList) {
			observerGenerator.update(promise);
		}
	}
}
