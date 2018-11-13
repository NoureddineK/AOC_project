package updateActiveObject;

import java.util.concurrent.Future;

public interface ObsGenAsync{

	public Future<Integer>  update(Integer input);
	public int getValue();
	public Future<Integer> create(Integer input);
	
}
	