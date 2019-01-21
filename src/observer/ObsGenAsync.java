package observer;

import generator.Generator;

public interface ObsGenAsync extends myObserver<Generator> {

	public void update(Generator generator);

}
