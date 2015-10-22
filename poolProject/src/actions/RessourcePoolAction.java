package actions;

import ressource.Ressource;
import ressource.RessourcePool;
import ressource.RessourcefulUser;

public abstract class RessourcePoolAction <R extends Ressource> extends Action {
	protected boolean isReady ;
	protected boolean isFinished ;
	protected RessourcePool<R> ressourcePool ;
	protected RessourcefulUser<R> ressourcefulUser ;
	
	public RessourcePoolAction(RessourcePool<R>ressourcePool,RessourcefulUser<R> ressourcefulUser){
		isReady = true ;
		isFinished = false;
		this.ressourcePool = ressourcePool ; 
	}
	
	public void reallyDoStep (){
		
	}
}
