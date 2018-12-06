package observer;

import java.util.Observer;
import java.util.concurrent.Future;

import generator.Generator;

public interface ObsGenAsync extends Observer {

	public Future<Integer> update(Generator generator);

}
