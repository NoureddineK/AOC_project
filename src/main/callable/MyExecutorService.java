package main.callable;

/** 
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * 
 * ScheduledExecutorService
 */
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MyExecutorService {
	private static final int NTHREDS = 10; 
	static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(NTHREDS);
	
	/**
	 * Return a Future to Canal (Update Generator, Promise)
	 * @param value
	 * @param time
	 * @return Future
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Future submit(Callable value, long time) {
		return scheduledExecutorService.schedule(value, time, TimeUnit.MILLISECONDS);
	}
}
