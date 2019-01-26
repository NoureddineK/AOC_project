package main.client;

import java.util.concurrent.ExecutionException;

import main.generator.*;
import main.view.Ihm;

public class mainApp {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Generator generator = new GeneratorAsync();
		Ihm ihm = new Ihm();
		ihm.setGenerator(generator);
    }
}
