package view;

import java.util.logging.Logger;

import javax.swing.JTextArea;
import canal.Canal;
import canal.CanalImp;
import canal.Promise;
import observer.ObserverCanal;

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

	@Override
	public void update(Canal canal) {
		LOGGER.info("update: ");
		int val = ((CanalImp) canal).getValue();
		this.textView.setText(String.valueOf(val));
		cycleValue = 0;
	}

	public void update(Promise promise) {
		if (cycleValue < promise.getPromiseValue()) {
			textView.setText(String.valueOf(promise.getValue()));
			cycleValue = promise.getPromiseValue();

		} else {
			// Do nothing, value ignored
		}
	}

}
