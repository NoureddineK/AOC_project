package Callable;

import updateActiveObject.Canal;
import view.Afficheur;

public class UpdateAfficheurCallable {
	private Canal canal;
	private Afficheur afficheur;

	public UpdateAfficheurCallable(Canal canal, Afficheur afficheur) {

		this.canal = canal;
		this.afficheur = afficheur;
	}

	public Object call() throws Exception {
		afficheur.update(canal);
		return null; 
	}

}
