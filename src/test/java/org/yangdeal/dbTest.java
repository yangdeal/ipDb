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

        test.createTable(db);
        test.addItem(db);
        Assert.assertEquals("The Big New Movie", test.queryTable(db));
        test.deleteTable(db);

    }
}
