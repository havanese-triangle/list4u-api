package com.havitri.list4u.api.entity

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository extends CrudRepository<ItemEntity, Long> {
}
