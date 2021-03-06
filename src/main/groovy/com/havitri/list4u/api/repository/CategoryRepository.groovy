package com.havitri.list4u.api.repository

import com.havitri.list4u.api.entity.CategoryEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
