package main.canal;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * Promise Object Used to Update Causal Value
 */
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