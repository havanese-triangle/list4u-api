package com.havitri.list4u.api.grocery

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<GroceryListItem> items = []
}
