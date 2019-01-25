package observer;

import generator.Generator;

public interface ObsGenAsync extends MyObserver<Generator> {

	public void update(Generator generator);

}
