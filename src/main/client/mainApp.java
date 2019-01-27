package main.client;

import java.util.concurrent.ExecutionException;

import main.generator.*;
import main.view.SwingIhm;

public class mainApp {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Generator generator = new GeneratorAsync();
		SwingIhm ihm = new SwingIhm();
		ihm.setGenerator(generator);
    }
}
