package canal;

public class Promise {
	private int value; 
	private int promiseVal;

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPromiseValue() {
		return this.promiseVal;
	}

	public void setPromiseValue(int promiseVal) {
		this.promiseVal = promiseVal;
	}

}