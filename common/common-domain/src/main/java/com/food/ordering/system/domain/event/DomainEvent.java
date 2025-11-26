package com.food.ordering.system.domain.event;
// <T> represents the entity that produced the event .
// order-created-event -> T = Order , product-created-event -> T = Product , customer-created-event -> T = Customer
public interface DomainEvent<T> {
}
