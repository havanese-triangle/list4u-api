package com.havitri.list4u.api.entity

import javax.persistence.*

@Entity(name = "item")
class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne
    @JoinColumn(name = "categoryId")
    ItemCategoryEntity category

    String name
}
