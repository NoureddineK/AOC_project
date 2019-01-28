package main.client;
/**
 * 
 * @author Noureddine KADRI & Fahim MERZOUK
 *
 * main Application  
 */
import java.util.concurrent.ExecutionException;

import main.generator.*;
import main.view.SwingIhm;

public class mainApp {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Generator generator = new GeneratorAsync();
		SwingIhm ihm = new SwingIhm();
		// Set IHM generator
		ihm.setGenerator(generator);
    }
}
