package org.yangdeal;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.junit.Assert;
import org.junit.Test;

import static org.yangdeal.dbTable.dbConnect;

public class dbTest {

    @Test
    public void readFromYaml() {
        config a = new config();
        Assert.assertEquals("ipDb", a.getDbTableName());
    }

    @Test
    public void test2() {
        DynamoDB db = dbConnect();
        dbTable test = new dbTable();
        try {
            test.createTable(db);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            test.addItem(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals("The Big New Movie", test.queryTable(db));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            test.deleteTable(db);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
