package com.havitri.list4u.api.entity

import javax.persistence.*

@Entity(name = "list")
class ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<ListItemEntity> items = []
}
