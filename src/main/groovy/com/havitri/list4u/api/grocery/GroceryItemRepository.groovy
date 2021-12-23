package com.havitri.list4u.api.grocery

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GroceryItemRepository extends CrudRepository<GroceryItem, Long> {
}
