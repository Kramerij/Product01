import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        final int FIELDS_LENGTH = 4;
        /* making an array of Products */
        ArrayList<String> ProductArray = new ArrayList<>();
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);

                    line++;
                }
                reader.close();
                //file has been read

                //making the output table
                System.out.println("Name      Description             ID           cost");
                System.out.println("=====================================================");
                String[] fields;
                for (String a : lines) {
                    fields = a.split(",", 0);

                    if (fields.length == FIELDS_LENGTH) {
                        ID = fields[0].trim();
                        name = fields[1].trim();
                        description = fields[2].trim();
                        cost = Double.parseDouble(fields[3].trim());
                        // System.out.printf("\n%-8s%-15s%-15s%-6s%6d", ID, name, description, cost);
                         ProductArray.add((new Product(ID, name, description, cost).toCSVRecord()));
                    } else {
                        System.out.println("File was corrupt");
                        System.out.println(a);
                    }
                }
                Iterator itr= ProductArray.iterator();
                while(itr.hasNext())
                {
                    Object Product = itr.next();
                    String formattedString = Product.toString()
                            .replace(",", "      ");

                    System.out.println(formattedString);

                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}


