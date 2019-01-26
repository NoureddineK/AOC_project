package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyExecutorService {
	private static final int NTHREDS = 10; 
	static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(NTHREDS);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Future submit(Callable value, long time) {
		return scheduledExecutorService.schedule(value, time, TimeUnit.MILLISECONDS);
	}
}
