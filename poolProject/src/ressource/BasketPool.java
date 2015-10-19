package ressource;

public class BasketPool extends RessourcePool<Basket>{
	
	public BasketPool (int n){
		super(n);
	}
	
	@Override
	protected Basket createRessource(){
		return new Basket();
	}

}
