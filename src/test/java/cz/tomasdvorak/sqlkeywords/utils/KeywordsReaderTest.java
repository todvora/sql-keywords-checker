package cz.tomasdvorak.sqlkeywords.utils;


import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class KeywordsReaderTest {

    @Test
    public void testGetAll() throws Exception {
        Set<String> all = KeywordsReader.getAll();
        Assert.assertNotNull(all);
        Assert.assertTrue(all.contains("call"));
        Assert.assertTrue(all.contains("character"));
        Assert.assertTrue(all.contains("select"));
    }
}
