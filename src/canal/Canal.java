package canal;

import generator.Generator;
import observer.MySubject;
import observer.ObserverCanal;
import observer.ObserverGenerator;

public interface Canal extends ObserverGenerator, MySubject {

	public Generator getGenerator();

	public void setGenerator(Generator generator);

	public ObserverCanal getDisplay();

	public void update(Generator generator);

	public int getValue();

}