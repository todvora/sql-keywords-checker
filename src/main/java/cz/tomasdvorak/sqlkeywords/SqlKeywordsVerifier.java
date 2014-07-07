package cz.tomasdvorak.sqlkeywords;


import cz.tomasdvorak.sqlkeywords.dto.PropertyIdentificator;
import cz.tomasdvorak.sqlkeywords.exceptions.AssertionException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SqlKeywordsVerifier {

    private final Class<?> clazz;
    private final Set<String> ignored = new HashSet<>();

    private SqlKeywordsVerifier(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static SqlKeywordsVerifier forClass(Class<?> clazz) {
        return new SqlKeywordsVerifier(clazz);
    }

    public SqlKeywordsVerifier ignore(String... identificators) {
        ignored.addAll(Arrays.asList(identificators));
        return this;
    }

    public void verify() {
        Set<PropertyIdentificator> invalidIdentificators = new SqlKeywordsChecker().getInvalidIdentificators(this.clazz);

        Set<PropertyIdentificator> filtered = filterIgnored(invalidIdentificators);

        if(!filtered.isEmpty()) {
            throw new AssertionException("Invalid identificators: " + Arrays.toString(filtered.toArray()));
        }
    }

    private Set<PropertyIdentificator> filterIgnored(final Set<PropertyIdentificator> invalidIdentificators) {
        Set<PropertyIdentificator> filtered = new HashSet<>();
        for(PropertyIdentificator identificator : invalidIdentificators) {
            if(!ignored.contains(identificator.getColumnName())) {
                filtered.add(identificator);
            }
        }
        return filtered;
    }
}
