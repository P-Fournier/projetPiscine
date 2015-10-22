package actions;

import ressource.Ressource;
import ressource.RessourcePool;
import ressource.RessourcefulUser;

public class TakeRessourceAction<R extends Ressource> extends RessourcePoolAction<R>{
	
	public TakeRessourceAction(RessourcePool<R> ressourcePool , RessourcefulUser<R> ressourcefulUser) {
		super(ressourcePool,ressourcefulUser);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
