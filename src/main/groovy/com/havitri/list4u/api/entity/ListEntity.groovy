package com.havitri.list4u.api.entity

import javax.persistence.*

@Entity(name = "list")
class ListEntity {

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

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<ListItemEntity> items = []
}
