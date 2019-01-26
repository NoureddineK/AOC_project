package Callable;

import updateActiveObject.Canal;
import view.Display;

public class UpdateAfficheurCallable {
	private Canal canal;
	private Display afficheur;

	public UpdateAfficheurCallable(Canal canal, Display afficheur) {

		this.canal = canal;
		this.afficheur = afficheur;
	}

	public Object call() throws Exception {
		afficheur.update(canal);
		return null; 
	}

}
