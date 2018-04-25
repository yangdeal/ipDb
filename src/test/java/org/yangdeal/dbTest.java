package org.yangdeal;

import org.junit.Assert;
import org.junit.Test;

public class dbTest {

    @Test
    public void readFromYaml() {
        config a = new config();
        Assert.assertEquals("ipDb", a.getDbTableName());
    }
}
