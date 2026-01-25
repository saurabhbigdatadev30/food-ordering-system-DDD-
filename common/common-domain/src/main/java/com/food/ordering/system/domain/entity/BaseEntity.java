package com.food.ordering.system.domain.entity;

import java.util.Objects;

   /**
     The BaseEntity<ID> is an abstract class that centralizes the management of entity identifiers for all the entities
     across the domain model i.e order domain , customer domain modules etc.

     1. We create an abstract class BaseEntity<ID>, with generic type parameter <ID>.
     2. We  define a field of this same generic type <ID>. i.e private ID id;
     3. This ensures that setId(...) only accepts Type = ID.
        So, gives compile-time checking: -

     if ->  "Order extends BaseEntity<OrderId>", so the ID type is bound as OrderId, So,setId(...) only accepts OrderId
             (not UUID, not CustomerId).
             The equals and hashcode will be inherited by Order class from BaseEntity class & will compare based on OrderId
             to compare the uniqueness .
    */

public abstract class BaseEntity<ID> {
  // Define a field "private ID id" field of the Generic type <ID> , this ensures that setId(...) only accepts Type ID .
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

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
