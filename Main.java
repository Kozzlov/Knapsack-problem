import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Main {
	
	private static List<Backpack> backpacks;
	private static Backpack record;
	private static int capasity;
	
	public static void main (String [] args){
		long startTime = System.nanoTime();
		final String fileName= "D:\\Рабочий стол\\8";
		Knapsack knap = ReadFromFile.readData(fileName);
		
		capasity = knap.getCapasity();
		int backpackSize = knap.getBackpacks().size();
		backpacks = knap.getBackpacks();
		BitSet variances = new BitSet(backpackSize);
		record = new Backpack();
		
		//System.out.println(Long.toBinaryString(convert(variances)));
		//System.out.println(variances);
		checkBest(variances);
		for(int i = 0; i<backpackSize; i++) {
			variances.clear();
			variances.set(i);
			//System.out.println(variances);
			checkBest(variances);
			//System.out.println(Long.toBinaryString(convert(variances)));
			for(int j = i+1; j<backpackSize; j++) {
				variances.clear();
				variances.set(i);
				int value = j;
				while(value < backpackSize) {
					variances.set(value);
					//System.out.println(variances);
					checkBest(variances);
					//System.out.println(Long.toBinaryString(convert(variances)));
					value++;
				}
			}
		}
		System.out.println("Record: Value: " + record.getValue() + " Weight: " + record.getWeight());
		System.out.println("Vectors: " + record.getBits().toString());
		long endTime  = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime / 1000000 + " Milisecods");
	}
	  public static long convert(BitSet bits) {
		    long value = 0L;
		    for (int i = 0; i < bits.length(); ++i) {
		      value += bits.get(i) ? (1L << i) : 0L;
		    }
		    return value;
		  }
	  public static void checkBest(BitSet bits) {
		    int totalValue = 0;
		    int totalWeight = 0;
		    boolean breaked = false;
		    for (int i = 0; i < backpacks.size(); i++) {
		    	if(bits.get(i)) {
		    		if(totalWeight <= capasity) {
			    		Backpack element = backpacks.get(i);
			    		totalValue += element.getValue();
			    		totalWeight += element.getWeight();
		    		}else {
			    		breaked = true;
			    		break;
			    	}
		    	}
		    }
		    if(!breaked) {
		    	if(totalWeight <= capasity) {
		    		if(totalValue > record.getValue()) {
		    			record.setValue(totalValue);
		    			record.setWeight(totalWeight);
		    			BitSet temp = new BitSet(backpacks.size());
		    			temp.or(bits);
		    			record.setBits(temp);
		    			System.out.println(record.getValue() +" : "+ record.getWeight() + " : " + record.getBits().toString());
		    		}
		    	}
		    }
		 }
}
