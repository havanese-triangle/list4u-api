package com.havitri.list4u.api.entity

import com.havitri.list4u.api.ItemState

import javax.persistence.*

@Entity(name = "list_item")
class ListItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne
    @JoinColumn(name = "listId")
    ListEntity list

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "itemId")
    ItemEntity item

    ItemState state = ItemState.TODO
}
