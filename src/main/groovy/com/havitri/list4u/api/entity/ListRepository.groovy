package com.havitri.list4u.api.entity

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ListRepository extends CrudRepository<ListEntity, Long> {
}
