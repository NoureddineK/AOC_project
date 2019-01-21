package observer;

import generator.GeneratorAsync;

public interface ObserverGenerator {
	public void update(GeneratorAsync subject) throws Exception;
}
