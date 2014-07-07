package cz.tomasdvorak.sqlkeywords;

import cz.tomasdvorak.sqlkeywords.dto.PropertyIdentificator;
import cz.tomasdvorak.sqlkeywords.utils.KeywordsReader;
import cz.tomasdvorak.sqlkeywords.utils.ReflectionUtils;

import java.util.HashSet;
import java.util.Set;

public class SqlKeywordsChecker {

    private final Set<String> keywords;

    public SqlKeywordsChecker() {
        this.keywords = KeywordsReader.getAll();
    }

    public Set<PropertyIdentificator> getInvalidIdentificators(Class<?> clazz) {
        final Set<PropertyIdentificator> identificators = ReflectionUtils.getAllIdentificators(clazz);
        final Set<PropertyIdentificator> invalid = new HashSet<>();
        for (PropertyIdentificator identificator : identificators) {
            if (this.keywords.contains(identificator.getColumnName().toLowerCase())) {
                invalid.add(identificator);
            }
        }
        return invalid;
    }
}
