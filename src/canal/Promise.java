package canal;

public class Promise {
	private int value; 
	private int promiseVal;

	public int get_value() {
		return value;
	}

	public void set_value(int value) {
		this.value = value;
	}

	public int get_versionNumber() {
		return promiseVal;
	}

	public void set_versionNumber(int promiseVal) {
		this.promiseVal = promiseVal;
	}

}