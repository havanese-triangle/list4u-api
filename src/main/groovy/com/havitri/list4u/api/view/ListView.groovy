package com.havitri.list4u.api.view

import com.havitri.list4u.api.entity.ListEntity

import java.util.stream.Collectors

class ListView {
    Long id
    String name
    List<Category> categories = []

    static ListView from(ListEntity list) {
        def listView = new ListView()
        listView.id = list.id
        def categoryNames = [] as Set
        list.items.each {
            def name = it.item?.category?.name
            if(name) {
                categoryNames << name
            }
        }
        categoryNames.each { categoryName ->
            def matches = list.items.findAll { listItem ->
                listItem?.item?.category?.name == categoryName
            }
            def items = matches.stream().map {
                new ListItem(id: it.id, name: it.item.name, state: it.state)
            }.collect(Collectors.toList())
            listView.categories << new Category(items: items)
        }
        listView
    }
}
