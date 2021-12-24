package com.havitri.list4u.api.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "category")
class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name

    @Column(unique = true)
    String uname

    void setName(String name) {
        this.name = name
        this.uname = name?.toUpperCase()
    }

}
