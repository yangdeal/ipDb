package org.yangdeal;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class config {

    final String configfile = "/ipDb.yml";
    Yaml yaml = new Yaml();

    private String dbTableName = "ipDb";

    public String getDbTableName() {
        return dbTableName;
    }

    public void setDbTableName(String dbTableName) {
        this.dbTableName = dbTableName;
    }

    public config() {

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
            System.out.println(111);
            Iterable<Object> itr = yaml.loadAll(in);
            System.out.println(itr.getClass());
            for (Object o : itr) {
                System.out.println("Loaded object type:" + o.getClass());
                System.out.println(o);
            }
        }
    }
}
