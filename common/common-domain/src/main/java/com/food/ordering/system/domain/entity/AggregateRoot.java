package com.food.ordering.system.domain.entity;
/**
  Aggregate Root is an entity that acts as the root for a cluster of related entities.
  It is responsible for maintaining the integrity of the aggregate and enforcing business rules.
  All access to the entities within the aggregate should go through the Aggregate Root.
 */
public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
}
