package cz.tomasdvorak.sqlkeywords.dto;


import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class PropertyTest {

    @Test
    public void verifyEquals() {
        EqualsVerifier.forClass(Property.class).verify();
    }
}
