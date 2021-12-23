package com.havitri.list4u.api.entity

import javax.persistence.*

@Entity(name = "item")
class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "categoryId")
    CategoryEntity category

    String name
}
