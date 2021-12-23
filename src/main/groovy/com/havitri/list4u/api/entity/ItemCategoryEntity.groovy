package com.havitri.list4u.api.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "item_category")
class ItemCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name
}
