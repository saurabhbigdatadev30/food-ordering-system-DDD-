package com.food.ordering.system.domain.valueobject;

import java.util.Objects;

public abstract class BaseId<T> {
    // We define a variable :- "final T value" of the same generic type <T> of the class BaseId<T>.
     private final T value;

     /**
        We create an abstract class BaseID<T> , with a generic type parameter <T> .
      1. We define a variable :- "final T value" of the same generic type <T> .
      2. The constructor initializes this 'T value' when a new instance of a subclass is created. So,  this enforces
         compile-time checking of the type of the identifier. Only the specified type <T> can be used as to initialize
         the constructor.
         So whatever Type parameter the subclass binds to Base<T> , the constructor of BaseId will only accept
         that Type parameter.
     */

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
