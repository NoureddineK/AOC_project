package main.generator;

import java.util.ArrayList;
import java.util.logging.Logger;
import main.canal.CanalImp;
import main.canal.Promise;
import main.diffusion.Diffusion;
import main.instruction.DisplayController;
import main.instruction.GenerateValue;
import main.observer.ObserverCanal;
import main.observer.ObserverGenerator;
import main.view.Display;

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

	public int getValue() {
		LOGGER.info("getValue: ");
		return this.diffusion.getDiffusionValue();
	}

	public void setValue(int value) {
		LOGGER.info("setValue: ");
		this.generatorValue = value;
	}

	public Diffusion getDiffusion() {
		return this.diffusion;
	}

	public void setDiffusion(Diffusion diffusion) {
		LOGGER.info("setDiffusion");
		this.generatorValue = 0;
		this.diffusion = diffusion;
		this.diffusion.configureDiffusion(this, genObserversList.size());
	}

	public void notifyObservers() {
		for (ObserverGenerator obs : genObserversList) {
			obs.update(this);
		}
	}

	public void executeGenerator() {
		this.diffusion.executeDiffusion();

	}

	public void start() {
		if (controller != null)
			controller.startDisplaying();
	}

	public void stop() {
		if (controller != null)
			controller.stopDisplaying();
	}

	public int getDiffusionValue() {
		return this.generatorValue;
	}

	public void attach(Object o) {
		CanalImp canal = new CanalImp(this);
		canal.setDisplay((Display) o);
		genObserversList.add(canal);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void detach(Object o) {
		genObserversList.remove((ObserverCanal) o);
	}

	public void setHologe(DisplayController displayController) {
		this.controller = displayController;
	}

	public int getCycleValue() {
		return cycleValue;
	}

	public void setCycleValue(int cycleValue) {
		this.cycleValue = cycleValue;
	}

	public void notifyObservers(Promise promise) {
		for (ObserverGenerator observerGenerator : genObserversList) {
			observerGenerator.update(promise);
		}
	}
}
