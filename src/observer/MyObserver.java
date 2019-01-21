package observer;

import java.util.concurrent.Future;

public interface MyObserver<T> {
	public Future<Void> update(T subject);
}
