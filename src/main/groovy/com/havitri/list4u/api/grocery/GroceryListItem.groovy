package com.havitri.list4u.api.grocery

import com.havitri.list4u.api.ItemState

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class GroceryListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @ManyToOne
    @JoinColumn(name = "listId")
    GroceryList list

    ItemState state = ItemState.TODO
}
