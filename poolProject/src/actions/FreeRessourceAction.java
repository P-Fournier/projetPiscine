package actions;

import ressource.Ressource;
import ressource.RessourcePool;

public class FreeRessourceAction<R extends Ressource> extends RessourcePoolAction<R>{

	
	public FreeRessourceAction(RessourcePool<R> ressourcePool, RessourcefulUser<R> ressourcefulUser) {
		super(ressourcePool, ressourcefulUser);
	}

	@Override
	boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
