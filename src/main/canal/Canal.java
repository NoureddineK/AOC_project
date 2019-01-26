package main.canal;

import main.generator.Generator;
import main.observer.MySubject;
import main.observer.ObserverCanal;
import main.observer.ObserverGenerator;

public interface Canal extends ObserverGenerator, MySubject {

	public Generator getGenerator();

	public void setGenerator(Generator generator);

	public ObserverCanal getDisplay();

	public void update(Generator generator);

	public int getValue();

}