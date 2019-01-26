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
	public static final int NB_AFFICHEUR = 4;
	private Generator generator;
	ArrayList<JLabel> labelList;
	ArrayList<Display> displayList;

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
		JRadioButton atomiqueBtn = new JRadioButton("Atomique");
		diffusionChoicePanel.add(atomiqueBtn);
		atomiqueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generator.stop();
				generator.setDiffusion(new AtomicDiffusion());
				generator.start();
			}

		});

		// Diffusion Sequentielle
		JRadioButton seqBtn = new JRadioButton("Sequentielle");
		diffusionChoicePanel.add(seqBtn);
		seqBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				generator.stop();
				generator.setDiffusion(new SequentialDiffusion());
				generator.start();
			}

		});

		// Diffusion Causale
		JRadioButton causBtn = new JRadioButton("Causale");
		diffusionChoicePanel.add(causBtn);
		causBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				generator.stop();
				generator.setDiffusion(new CausalDiffusion());
				generator.start();
			}

		});
		radioButtons.add(causBtn);
		radioButtons.add(atomiqueBtn);
		radioButtons.add(seqBtn);

		// Afficheurs Label
		labelList = new ArrayList<JLabel>();
		for (int i = 0; i < NB_AFFICHEUR; i++) {
			JLabel labaff = new JLabel("Display_" + (i + 1));

			labelList.add(labaff);
		}
		// Ajout des textView
		displayList = new ArrayList<Display>();
		for (int i = 0; i < NB_AFFICHEUR; i++) {
			JTextArea textArea = new JTextArea(2, 3);
			textArea.setBackground(Color.CYAN);
			displayList.add(new Display(textArea));
		}

		for (int i = 0; i < NB_AFFICHEUR; i++) {
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

	public void setCapteur(Generator generator) {
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
