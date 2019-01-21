package observer;

import java.util.concurrent.Future;

import generator.Generator;

public interface ObsGenAsync extends MyObserver<Generator> {

	public Future<Void> update(Generator generator);

}
