package org.yangdeal;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public final class config {
    final String configfile = "/ipDb.yaml";
    Yaml yaml = new Yaml();

    private String dbTableName = "ipDb";

    public String getDbTableName() {
        return dbTableName;
    }

    public void setDbTableName(String dbTableName) {
        this.dbTableName = dbTableName;
    }

    public config() {
//        try {
//            testFile(configfile);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            loadFromFile(configfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadFromFile(String path) throws IOException {
        System.out.printf("-- loading from %s --%n", path);
        Yaml yaml = new Yaml();
        try (InputStream in = config.class.getResourceAsStream(path)) {
            Iterable<Object> itr = yaml.loadAll(in);
            for (Object o : itr) {
                System.out.println("Loaded object type:" + o.getClass());
                System.out.println(o);
            }
        }
    }

    public static void testFile(String configfile) throws IOException {
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the filename.
        String filename = configfile;

        // Open the file.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // Read lines from the file until no more are left.
        while (inputFile.hasNext())
        {
            // Read the next name.
            String familyName = inputFile.nextLine();

            // Display the last name read.
            System.out.println(familyName);

        }

        // Close the file.
        inputFile.close();
        keyboard.close();
    }
}
