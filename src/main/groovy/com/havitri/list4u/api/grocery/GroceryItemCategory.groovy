package com.havitri.list4u.api.grocery

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class GroceryItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name
}
