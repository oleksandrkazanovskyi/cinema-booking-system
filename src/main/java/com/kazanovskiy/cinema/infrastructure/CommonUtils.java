package com.kazanovskiy.cinema.infrastructure;

import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

@UtilityClass
public class CommonUtils {

    public <T> T safeGet(T object, Supplier<? extends RuntimeException> exceptionSupplier) {
        return Optional.ofNullable(object).orElseThrow(exceptionSupplier);
    }
}
