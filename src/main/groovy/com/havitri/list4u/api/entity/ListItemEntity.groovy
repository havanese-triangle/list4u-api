package com.havitri.list4u.api.entity

import com.havitri.list4u.api.ItemState

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "list_item")
class ListItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne
    @JoinColumn(name = "listId")
    ListEntity list

    ItemState state = ItemState.TODO
}
