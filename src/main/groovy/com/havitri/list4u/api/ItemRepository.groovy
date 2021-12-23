package com.havitri.list4u.api

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository extends CrudRepository<Item, Long> {
}
