package actions;

import ressource.Basket;
import ressource.BasketPool;
import ressource.Cubicle;
import ressource.CubiclePool;

public class Swimmer extends SequentialScheduler {
	private String name;
	private BasketPool baskets;
	private CubiclePool cubicles;
	private int undressTime;
	private int swimTime;
	private int dressTime; 
	
	public Swimmer (String name,BasketPool baskets,CubiclePool cubicles,int undressTime,
			int swimTime , int dressTime){
		super ();
		this.name = name;
		this.baskets = baskets;
		this.cubicles = cubicles;
		this.undressTime = undressTime;
		this.swimTime = swimTime;
		this.dressTime = dressTime;
		RessourcefulUser<Cubicle> ruCubicle = new RessourcefulUser<Cubicle> (this);
		RessourcefulUser<Basket> ruBasket = new RessourcefulUser<Basket> (this);
		addAction(new TakeRessourceAction<Basket>(this.baskets,ruBasket)); // reserve a basket
		addAction(new TakeRessourceAction<Cubicle>(this.cubicles,ruCubicle)); // reserve a cubicle
		addAction(new ForeseebleAction(this.undressTime,"undressing")); // undressing
		addAction(new FreeRessourceAction<Cubicle>(this.cubicles,ruCubicle)); // free a cubicle
		addAction(new ForeseebleAction(this.swimTime,"swimming")); // swimming
		addAction(new TakeRessourceAction<Cubicle>(this.cubicles,ruCubicle)); // reserve a cubicle
		addAction(new ForeseebleAction(this.dressTime,"dressing")); // dressing
		addAction(new FreeRessourceAction<Cubicle>(this.cubicles,ruCubicle)); // free a cubicle
		addAction(new FreeRessourceAction<Basket>(this.baskets,ruBasket)); // free a basket
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BasketPool getBaskets() {
		return baskets;
	}

	public void setBaskets(BasketPool baskets) {
		this.baskets = baskets;
	}

	public CubiclePool getCubicles() {
		return cubicles;
	}

	public void setCubicles(CubiclePool cubicles) {
		this.cubicles = cubicles;
	}

	public int getUndressTime() {
		return undressTime;
	}

	public void setUndressTime(int undressTime) {
		this.undressTime = undressTime;
	}

	public int getSwimTime() {
		return swimTime;
	}

	public void setSwimTime(int swimTime) {
		this.swimTime = swimTime;
	}

	public int getDressTime() {
		return dressTime;
	}

	public void setDressTime(int dressTime) {
		this.dressTime = dressTime;
	}
	
	
}
