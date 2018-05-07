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

        dbTable.createTable(db);
        dbTable.addItem(db);
        Assert.assertEquals("The Big New Movie", dbTable.queryTable(db));
        dbTable.deleteTable(db);

    }
}
