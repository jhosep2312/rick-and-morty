package com.bolivar.rick_and_morthy.infraestructure.utils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Stream.empty;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class FunctionUtils {

    public static <T> Stream<T> safeStream(final Collection<T> collection) {
        return isEmpty(collection) ? empty() : collection.stream().filter(Objects::nonNull);
    }

    public static <T> void updateEntity(T target, T source) {
        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
