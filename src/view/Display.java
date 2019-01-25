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
	private int myEposqVersion = -1;

	public Display(JTextArea textView) {
		LOGGER.info("Constructor: ");
		this.textView = textView;
		myEposqVersion = -1;
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
		myEposqVersion = -1;
	}

	public void update(Promise msgepoq) {

		if (myEposqVersion < msgepoq.get_versionNumber()) {

			textView.setText(String.valueOf(msgepoq.get_value()));
			myEposqVersion = msgepoq.get_versionNumber();

		} else {
			// receiving an old version : simply ignore it
		}
	}

}
