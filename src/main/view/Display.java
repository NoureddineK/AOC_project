package main.view;

import java.util.logging.Logger;

import javax.swing.JTextArea;
import main.canal.Canal;
import main.canal.CanalImp;
import main.canal.Promise;
import main.observer.ObserverCanal;

public class Display implements ObserverCanal {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private JTextArea textView;
	private int cycleValue = 0;

	public Display(JTextArea textView) {
		LOGGER.info("Constructor: ");
		this.textView = textView;
		cycleValue = 0;
	}

	public JTextArea getComponent() {
		return this.textView;
	}

	public void setComponent(JTextArea textView) {
		this.textView = textView;
	}

	public void update(Canal canal) {
		LOGGER.info("update: ");
		int val = ((CanalImp) canal).getValue();
		this.textView.setText(Integer.toString(val));
		System.out.println("Update Canal: "+Integer.toString(val));
		cycleValue = 0;
	}

	public void update(Promise promise) {
		if (cycleValue < promise.getPromiseValue()) {
			textView.setText(Integer.toString(promise.getValue()));
			System.out.println("Update promise: "+Integer.toString(promise.getValue()));
			cycleValue = promise.getPromiseValue();

		} else {
			// Do nothing, value ignored
		}
	}
}
