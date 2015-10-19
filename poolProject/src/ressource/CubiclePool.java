package ressource;

public class CubiclePool extends RessourcePool<Cubicle>{

	public CubiclePool (int n){
		super (n);
	}
	
	@Override
	protected Cubicle createRessource(){
		return new Cubicle();
	}
	
}
