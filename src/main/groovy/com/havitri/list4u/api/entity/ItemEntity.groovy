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

    @Column(unique = true)
    String uname

    void setName(String name) {
        this.name = name
        this.uname = name?.toUpperCase()
    }

}
