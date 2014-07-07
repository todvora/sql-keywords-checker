package cz.tomasdvorak.sqlkeywords.dto;


import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class PropertyIdentificatorTest {

    @Test
    public void verifyEquals() {
        EqualsVerifier.forClass(PropertyIdentificator.class).verify();
    }
}
