package cz.tomasdvorak.sqlkeywords;


import cz.tomasdvorak.sqlkeywords.exceptions.AssertionException;
import org.junit.Assert;
import org.junit.Test;

public class SqlKeywordsVerifierTest {

    @Test
    public void testVerify() {
        try {
            SqlKeywordsVerifier.forClass(TestData.TestEntity.class).verify();
            Assert.fail("Should throw exception");
        } catch (AssertionException e) {
            Assert.assertTrue(e.getMessage().contains("call"));
            Assert.assertTrue(e.getMessage().contains("statement"));
            Assert.assertTrue(e.getMessage().contains("name"));
        }
    }

    @Test
    public void testVerifyWithIgnored() {
        try {
            SqlKeywordsVerifier.forClass(TestData.TestEntity.class).ignore("name").verify();
            Assert.fail("Should throw exception");
        } catch (AssertionException e) {
            Assert.assertTrue(e.getMessage().contains("call"));
            Assert.assertTrue(e.getMessage().contains("statement"));
            Assert.assertFalse(e.getMessage().contains("name"));
        }
    }
}
