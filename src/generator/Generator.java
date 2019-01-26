package generator;

import canal.Promise;
import diffusion.Diffusion;
import observer.MySubject;

public interface Generator extends MySubject {

	public int getValue();

	public void setValue(int value);

	public void executeGenerator();

	public void start();

	public void stop();

	public void notifyObservers();

	public Diffusion getDiffusion();

	public void setDiffusion(Diffusion diffusion);

	public int getDiffusionValue();

	public int getCycleValue();

	public void setCycleValue(int value);

	public void notifyObservers(Promise promise);

}
