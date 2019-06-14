import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadFromFile {
//public static Names readData(String fileName) {
	public static Knapsack readData(String fileName) {
	File file = new File(fileName);
	Knapsack knap = new Knapsack();
	List<Backpack> backpacks = new ArrayList<>();
	    try{
	    	BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()), UTF_8);
	    	String line = reader.readLine();
	    	knap.setCapasity(Integer.parseInt(line));
	    	line = reader.readLine();
	    	while (line != null) {
	    		String[] valueWeight = line.split(" ");
	    		int value = Integer.parseInt(valueWeight[0]);
	    		int weight =Integer.parseInt(valueWeight[1]);
	    		backpacks.add(new Backpack(value,weight));
	    		line = reader.readLine();
	    	}
	    	reader.close();
	    	knap.setBackpacks(backpacks);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	    return knap;
	}
}