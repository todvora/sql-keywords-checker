package cz.tomasdvorak.sqlkeywords.utils;

import cz.tomasdvorak.sqlkeywords.TestData;
import cz.tomasdvorak.sqlkeywords.dto.PropertyIdentificator;
import cz.tomasdvorak.sqlkeywords.utils.ReflectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ReflectionUtilsTest {

    @Test
    public void testGetAllIdentificators() throws Exception {
        Set<PropertyIdentificator> allIdentificators = ReflectionUtils.getAllIdentificators(TestData.TestEntity.class);
        Assert.assertNotNull(allIdentificators);
        Assert.assertEquals(6, allIdentificators.size());
        Assert.assertTrue(allIdentificators.contains(new PropertyIdentificator(TestData.TestEntityBase.class, "statement", "statement")));
    }


}
