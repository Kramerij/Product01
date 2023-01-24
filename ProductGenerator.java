import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<String> productCSVData = new ArrayList<>();
        ArrayList<String> productOData = new ArrayList<>();
        String id = "";
        String name = "";
        String description = "";
        String CSVProductRecord = "";
        double cost = 0;

        Boolean done = false;
        Boolean enteringDone = false;
        Scanner input = new Scanner(System.in);
        do{
            do {
                id = SafeInput.getNonZeroLenString(input, "Please enter the ID");
                System.out.println("ID is:" + id);
                name = SafeInput.getNonZeroLenString(input, "What is the name?");
                System.out.println("the name is " + name);
                description = SafeInput.getNonZeroLenString(input, "What is the description");
                System.out.println("the description name is " + description);
                cost = SafeInput.getDouble(input, "What is the cost?");
                System.out.println("the cost is" + cost);
           /* CSVPersonRecord = id + "," + name + "," + description + "," + title + "," + cost;
            personCSVData.add(CSVPersonRecord);*/

                productOData.add(new Product(id, name, description, cost).toCSVRecord());

                enteringDone = SafeInput.getYNConfirm(input, "have you finished entering the product's data?");
            } while (!enteringDone);
            done = SafeInput.getYNConfirm(input, "Are you done entering products?");
        }
        while (!done);
        for (String p : productOData)
            System.out.println(p);
//* Writing the CVS file *//
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductData.txt");

        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : productOData)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

