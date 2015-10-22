package ressource;

import actions.Swimmer;

public class RessourcefulUser<R extends Ressource> {
	
	protected Swimmer user ;
	protected R used ;
	
	public RessourcefulUser (Swimmer user){
		this.user = user;
		this.used = null;
	}

	public Swimmer getUser() {
		return user;
	}

	public void setUser(Swimmer user) {
		this.user = user;
	}

	public R getUsed() {
		return used;
	}

	public void setUsed(R used) {
		this.used = used;
	}
	
	public void resetUsed(){
		this.used = null;
	}
	

}
