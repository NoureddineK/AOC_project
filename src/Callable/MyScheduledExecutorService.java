package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledExecutorService {
	private static final int THREDS = 5;
	static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREDS);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Future submit(Callable worker, long time) {

		return scheduledExecutorService.schedule(worker, time, TimeUnit.MILLISECONDS);

	}
}
