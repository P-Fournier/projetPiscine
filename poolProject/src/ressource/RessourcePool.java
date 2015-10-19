package ressource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class RessourcePool <R extends Ressource>{
	
	private List<R> poolFree;
	private List<R> poolUsed;
	
	public RessourcePool (int n){
		this.poolFree = new ArrayList<R> (n);
		this.poolUsed = new ArrayList<R> (n);
		for (int i=0 ; i<n ; i++){
			poolFree.add(createRessource());
		}
	}
	
	public R provideRessource () {
		if (hasAvailableRessource()){
			R r = poolFree.remove(0);
			poolUsed.add(r);
			return r;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	protected abstract R createRessource ();
	
	public boolean hasAvailableRessource () {
		return poolFree.isEmpty();
	}
	
	public void freeRessource (R r){
		int idRessourceUsed = this.poolUsed.indexOf(r);
		if (idRessourceUsed != -1){
			this.poolUsed.remove(idRessourceUsed);
			this.poolFree.add(r);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	
}
