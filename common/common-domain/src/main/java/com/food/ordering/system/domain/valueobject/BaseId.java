package com.food.ordering.system.domain.valueobject;

import java.util.Objects;

/**
    BaseId is a generic abstract class that represents a value object for unique identifiers.
    It encapsulates a value of type T and provides methods for equality comparison and hash code generation.
 */
public abstract class BaseId<T> {
    private final T value;

    // Immtutable class so  to initialize the value we use constructor
    protected BaseId(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
