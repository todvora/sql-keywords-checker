package cz.tomasdvorak.sqlkeywords.utils;

import cz.tomasdvorak.sqlkeywords.dto.PropertyIdentificator;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class ReflectionUtils {

    public static Set<PropertyIdentificator> getAllIdentificators(Class<?> clazz) {
        final Set<PropertyIdentificator> identificators = new HashSet<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field : declaredFields) {
            if(isEntityProperty(field)) {
                identificators.add(createIdentificator(clazz, field));
            }
        }

        if(clazz.getSuperclass() != null) {
            identificators.addAll(getAllIdentificators(clazz.getSuperclass()));
        }

        return identificators;
    }

    private static PropertyIdentificator createIdentificator(Class<?> clazz, Field field) {
        return new PropertyIdentificator(clazz, field.getName(), field.getName());
    }

    private static boolean isEntityProperty(Field field) {
        return true;
    }
}
