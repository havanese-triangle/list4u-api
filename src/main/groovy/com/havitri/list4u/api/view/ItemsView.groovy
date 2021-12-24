package com.havitri.list4u.api.view

import com.havitri.list4u.api.entity.CategoryEntity
import com.havitri.list4u.api.entity.ItemEntity

import java.util.stream.Collectors

class ItemsView {
    List<CategoryView> categories = []

    static ItemsView from(List<ItemEntity> items) {
        def itemsView = new ItemsView()
        def categorySet = [] as Set<CategoryEntity>
        items.each {
            categorySet << it.category
        }
        categorySet.each { category ->
            def matches = items.findAll { item ->
                category.id == item.category?.id
            }
            def availableItems = matches.stream().map {
                new AvailableItem(id: it.id, name: it.name)
            }.collect(Collectors.toList())
            itemsView.categories << new CategoryView(items: availableItems, name: category.name, id: category.id)
        }
        itemsView
    }
}
