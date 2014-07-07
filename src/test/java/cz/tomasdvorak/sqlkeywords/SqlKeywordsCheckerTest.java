package cz.tomasdvorak.sqlkeywords;

import cz.tomasdvorak.sqlkeywords.dto.PropertyIdentificator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SqlKeywordsCheckerTest {

    @Test
    public void testInvalidIdentificators() {
        Set<PropertyIdentificator> invalid = new SqlKeywordsChecker().getInvalidIdentificators(TestData.TestEntity.class);
        Assert.assertNotNull(invalid);
        final Set<String> ids = new HashSet<>();
        for(PropertyIdentificator identificator : invalid) {
            ids.add(identificator.getColumnName());
        }

        Assert.assertEquals(ids, new HashSet<>(Arrays.asList("name", "call", "statement")));
    }
}
