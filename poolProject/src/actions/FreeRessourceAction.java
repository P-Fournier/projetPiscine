package actions;

import ressource.Ressource;
import ressource.RessourcePool;
import ressource.RessourcefulUser;

public class FreeRessourceAction<R extends Ressource> extends RessourcePoolAction<R>{

	
	public FreeRessourceAction(RessourcePool<R> ressourcePool, RessourcefulUser<R> ressourcefulUser) {
		super(ressourcePool, ressourcefulUser);
	}

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

}
