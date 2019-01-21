package generator;

import java.util.concurrent.Future;

import observer.ObserverGenerator;

public interface GeneratorAsync {

	public Future<Integer> getValue();

	public void attach(ObserverGenerator obs);

	public void detach(ObserverGenerator obs);

}
