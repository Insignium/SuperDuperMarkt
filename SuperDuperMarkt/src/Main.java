import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        List<Product> wares = new ArrayList<>();

        switch (in.nextLine()) {

            case "random":
                for (int i = 0; i < 10; i++) {
                    if (Math.random() < 0.6) {
                        if (Math.random() < 0.6) {
                            wares.add(new Crackers());
                        } else {
                            wares.add(new Kaese());
                        }
                    } else {
                        wares.add(new Wein());
                    }
                }
            case "csv":
                File file = new File("src/wares.csv");
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    String[] product = reader.nextLine().split(",");
                    if (product[0].equals("K")) {
                        wares.add(new Kaese(product[1], Integer.parseInt(product[2]), LocalDate.now()));
                    }
                    if (product[0].equals("W")) {
                        wares.add(new Wein(product[1], Integer.parseInt(product[2])));
                    }
                    if (product[0].equals("C")) {
                        wares.add(new Crackers(product[1], Integer.parseInt(product[2]), LocalDate.now()));
                    }
                }
        }

        ProductHandler handler = new ProductHandler(wares);

        while (!in.hasNext("close")) {
            if (in.nextLine().equals("next")) {
                handler.nextDay();
            }
        }
    }
}
