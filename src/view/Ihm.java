package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import diffusion.*;
import generator.*;

public class Ihm extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	public static final int NB_MONITOR = 4;
	private Generator generator;
	private ArrayList<JLabel> labelList;
	private ArrayList<Display> displayList;

	public Ihm() {
		// Init View
		JPanel displayView = new JPanel();
		displayView.setBackground(Color.LIGHT_GRAY);
		displayView.setLayout(new FlowLayout());

		// Radio Buttons
		ButtonGroup radioButtons = new ButtonGroup();
		JPanel diffusionChoicePanel = new JPanel();
		diffusionChoicePanel.setBackground(Color.WHITE);

		// Diffusion Atomique
		JRadioButton atomicBtn = new JRadioButton("Atomic");
		diffusionChoicePanel.add(atomicBtn);
		atomicBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generator.stop();
				generator.setDiffusion(new AtomicDiffusion());
				generator.start();
			}

		});

		// Diffusion Sequentielle
		JRadioButton sequentialBtn = new JRadioButton("Sequential");
		diffusionChoicePanel.add(sequentialBtn);
		sequentialBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				generator.stop();
				generator.setDiffusion(new SequentialDiffusion());
				generator.start();
			}

		});

		// Diffusion Causale
		JRadioButton causalBtn = new JRadioButton("Causal");
		diffusionChoicePanel.add(causalBtn);
		causalBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				generator.stop();
				generator.setDiffusion(new CausalDiffusion());
				generator.start();
			}

		});
		radioButtons.add(causalBtn);
		radioButtons.add(atomicBtn);
		radioButtons.add(sequentialBtn);

		// Afficheurs Label
		labelList = new ArrayList<JLabel>();
		for (int i = 0; i < NB_MONITOR; i++) {
			JLabel labaff = new JLabel("Display_" + (i + 1));

			labelList.add(labaff);
		}
		// Ajout des textView
		displayList = new ArrayList<Display>();
		for (int i = 0; i < NB_MONITOR; i++) {
			JTextArea textArea = new JTextArea(2, 3);
			textArea.setBackground(Color.CYAN);
			displayList.add(new Display(textArea));
		}

		for (int i = 0; i < NB_MONITOR; i++) {
			displayView.add(labelList.get(i));
			displayView.add(((Display) displayList.get(i)).getComponent());
		}

		// Init mainView
		getContentPane().setLayout(new BorderLayout());
		setLayout(new GridLayout(1, 2));
		getContentPane().add(diffusionChoicePanel);
		getContentPane().add(displayView);
		this.setPreferredSize(new Dimension(1000, 400));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public JFrame getParentFrame() {
		return this;
	}

	public void setGenerator(Generator generator) {
		System.out.println("Ihm setting Generator");
		this.generator = generator;
		registerObservers((GeneratorAsync) generator);

	}

	private void registerObservers(GeneratorAsync c) {
		System.out.println("Display: " + displayList.size() + " observers");
		for (int i = 0; i < displayList.size(); i++) {
			c.attach((Display) displayList.get(i));
		}
	}

	public Display getDisplay(int index) {
		try {
			if (index >= 0 && index < displayList.size())
				return (Display) displayList.get(index);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return null;
	}

}
