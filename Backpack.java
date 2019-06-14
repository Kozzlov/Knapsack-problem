import java.util.BitSet;

public class Backpack {
	private int value;
	private int weight;
	private BitSet bits;
	Backpack(){
		
	}
	Backpack(int value, int weight){
		this.value = value;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BitSet getBits() {
		return bits;
	}
	public void setBits(BitSet bits) {
		this.bits = bits;
	}
}
