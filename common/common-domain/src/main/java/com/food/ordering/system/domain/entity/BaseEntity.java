package com.food.ordering.system.domain.entity;

import java.util.Objects;
   /**
    1. Create abstract class BaseEntity<ID> class with Generic <ID> variable.
    2. Create private ID field with this Generic type <ID>  .
    3. Define getter and setter for this id field.
    4. Override equals() & hashCode() methods based on this id field.
    5. This class will be extended by the entity classes in the domain layer.
    6. It provides common functionality for entities, such as equality checks based on the identifier.
       So, we are implementing the concept of Entity from Domain-Driven Design (DDD) & avoid code duplication
       across multiple entity classes to obtain the identifier functionality overriding equals() & hashCode() methods.
    */
public abstract class BaseEntity<ID> {
    // Create private ID field with this Generic type <ID>
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    // Override equals() & hashCode() methods based on this id field to identify the entity uniquely by its identifier.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
