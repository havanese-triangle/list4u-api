package com.havitri.list4u.api.repository

import com.havitri.list4u.api.entity.ListEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ListRepository extends CrudRepository<ListEntity, Long> {
}
