package updateActiveObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Canal implements ObsGenAsync {
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	@Override
	public Future<Integer> update(Integer input) {
		return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Future<Integer> create(Integer input) {
		return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
	}

}
