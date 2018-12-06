package client;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import diffusion.AtomiqueDiffusion;
import generator.GeneratorImp;
import updateActiveObject.Canal;
import view.Afficheur;

public class mainTest {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Afficheur afficheur = new Afficheur();
		Canal canal = new Canal();
		AtomiqueDiffusion diffusionAtom = new AtomiqueDiffusion(canal);
		GeneratorImp generator = new GeneratorImp(0, new ArrayList<>(), new ArrayList<>(), diffusionAtom);
		generator.attach(afficheur);
		generator.attach(canal);
		generator.setValue(2);
	}
}
