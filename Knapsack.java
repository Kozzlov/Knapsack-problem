import java.util.ArrayList;
import java.util.List;

public class Knapsack {


	private int capasity;
	private List<Backpack> backpacks;
	
	Knapsack(){
		this.backpacks = new ArrayList<Backpack>();
	}
	
	Knapsack(int capasity){
		this.capasity = capasity;
		this.backpacks = new ArrayList<Backpack>();
	}
	
	public int getCapasity() {
		return capasity;
	}

	public void setCapasity(int capasity) {
		this.capasity = capasity;
	}

	public List<Backpack> getBackpacks() {
		return backpacks;
	}

	public void setBackpacks(List<Backpack> backpacks) {
		this.backpacks = backpacks;
	}
	

}
