package observer;

import canal.Promise;

public interface MyObserver<T> {
	public void update(T subject);
	public void update(Promise msgepoq);
}
