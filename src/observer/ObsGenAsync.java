package observer;

import java.util.concurrent.Future;

import generator.Generator;

public interface ObsGenAsync{

	public Future<Integer>  update(Generator generator);
	
}
	