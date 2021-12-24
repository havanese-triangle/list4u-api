package com.havitri.list4u.api.repository

import com.havitri.list4u.api.entity.ListItemEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ListItemRepository extends CrudRepository<ListItemEntity, Long> {
}
