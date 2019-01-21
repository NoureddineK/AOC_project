package observer;

import java.util.concurrent.Future;

public interface myObserver<T> {
	public Future<Void> update(T subject);
}
