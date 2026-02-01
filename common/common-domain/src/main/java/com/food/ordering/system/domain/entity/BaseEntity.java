package com.food.ordering.system.domain.entity;

import java.util.Objects;

   /**

     The BaseEntity<ID> is an abstract class that centralizes the management of entity identifiers for all the entities
     across the domain model i.e order domain , customer domain modules etc.

     1. We create an abstract class BaseEntity<ID>, with generic type parameter <ID>.
     2. We  define a field of this same generic type <ID>. i.e private ID id;
     3. This ensures that setId(...) only accepts Type = ID.


    ✅  When Order extends AggregateRoot<OrderId>
         At compile time, the compiler binds:
            - Generic type parameter: ID → OrderId
            - Inherited field becomes (conceptually): private OrderId id;
            - Type-safe methods: setId(OrderId) and OrderId getId()

    // BaseEntity (as bound to OrderId)
        public abstract class BaseEntity {
        private OrderId id;  // ✅ Generic ID bound to OrderId

        public void setId(OrderId id) {  // ✅ Type-safe setter
        this.id = id;
        }

        public OrderId getId() {  // ✅ Type-safe getter
        return this.id;
    }
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
