package com.havitri.list4u.api

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name
}
