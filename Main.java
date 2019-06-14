import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    private static int capacity = 0;

    private static StringBuilder bestSeq = new StringBuilder(); //you can change on array of 1
    private static int bestValue = 0;
    private static int bestWeight = 0;
    private static ArrayList<Item> vectors = new ArrayList<>(); //make array not list

    private static final File MyFile = new File("D:\\Рабочий стол\\NAI\\8");

    public static void main(String[] args) {
        readData(MyFile);
        BruteForseMethod((int) Math.pow(2, vectors.size()));

//       Answers:
//       AnswerVector: 001001001011000000111001000110
//       Total Value- 718
//       Total Weight- 200
//       Time for Calculations: 5.33300705685 minutes

    }

    // using BruteForseMethod to find best solution

    private static void BruteForseMethod(int allCombinations) {

        StringBuilder currSeq = new StringBuilder();
        int currValue, currWeight;

        long start = System.nanoTime();

        for (int c = 1; c < allCombinations; ++c) {

            currSeq.delete(0, currSeq.length());
            currWeight = 0;
            currValue = 0;
            currSeq.append(toBinary(c));

            for (int i = 0; i < currSeq.length(); ++i) {
                if (currSeq.charAt(i) == '1') {
                    currValue += vectors.get(i).value;
                    currWeight += vectors.get(i).weight;
                }
            }
            if (currValue > bestValue && currWeight <= capacity) {
                bestSeq.delete(0, bestSeq.length());
                bestWeight = currWeight;
                bestValue = currValue;
                bestSeq.append(currSeq);
            }
        }
        while (bestSeq.length() < vectors.size()) {
            bestSeq.append("0");
        }

        long end = System.nanoTime();

        double seconds = (double) (end - start) / 1_000_000_000.0;
        System.out.println("Answer Vector-" + bestSeq
                + "\n it's value- " + bestValue
                + "\n it's weight- " + bestWeight
                + "\n time was spent om that- " + (seconds / 60) + " minutes");
    }

    // here, i just read fdata from the file

    private static void readData(File file) {
        if (!file.exists() || !file.isFile()) {
            System.out.println("File does not exist or it is not a file");
            System.exit(-1);
        }
        try {
            BufferedReader readData = Files.newBufferedReader(Paths.get(file.toURI()), UTF_8);
            capacity = Integer.parseInt(readData.readLine());
            String line = readData.readLine();
            do {
                String data[] = line.split(" ");
                vectors.add(new Item(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                line = readData.readLine();
            }
            while (line != null);
            readData.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible to read data from the file");
            System.exit(-2);
        }
    }

    // changing my vectors to the binary format

    private static String toBinary(int value){
        StringBuilder binary = new StringBuilder();
        while (value > 0) {
            binary.append(value % 2);
            value /= 2;
        }
        return binary.toString();
    }
}


