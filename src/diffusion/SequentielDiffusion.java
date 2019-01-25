package diffusion;

import java.util.ArrayList;
import java.util.logging.Logger;

import generator.Generator;
import generator.GeneratorImp;

public class SequentielDiffusion implements Diffusion {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private int nbObservers = 0;
	private int nbUpdatesReq = 0;
	private Generator generator;
	private ArrayList<Integer> listValues; // Garde les differentes valeur du capteur
	private int curr_index_value; // Geré les valeur a envoyer aux observateurs

	public SequentielDiffusion() {
		LOGGER.info("Constructor : ");
		listValues = new ArrayList<Integer>();
	}

	public void setGenerator(GeneratorImp generator) {
		LOGGER.info("setValue : ");
		this.generator = generator;
	}

	@Override
	public int getDiffusionValue() {
		LOGGER.info("getDiffusionValue : ");
		nbUpdatesReq++;
		System.out.println(" Get value : req num : " + nbUpdatesReq + " --- nb obs: " + nbObservers);
		if (curr_index_value < listValues.size() && curr_index_value > -1) {
			return listValues.get(curr_index_value);
		}
		return 0;

	}

	@Override
	public void configureDiffusion(Generator generator, int nbObservers) {
		LOGGER.info("configureDiffusion : ");
		listValues = new ArrayList<Integer>();
		curr_index_value = -1;//
		this.generator = generator;
		this.nbObservers = nbObservers;
	}

	@Override
	public void executeDiffusion() {
		LOGGER.info("executeDiffusion : ");
		int generatorValue = generator.getDiffusionValue();
		listValues.add(generatorValue);
		this.generator.setValue(generatorValue + 1);

		if ((curr_index_value == -1) // first émmision
				|| (nbUpdatesReq >= nbObservers)) {
			curr_index_value++;
			nbUpdatesReq = 0;
			generator.notifyObservers();

		}
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;

	}

}
