package com.havitri.list4u.api.service

import com.havitri.list4u.api.entity.*
import com.havitri.list4u.api.repository.CategoryRepository
import com.havitri.list4u.api.repository.ItemRepository
import com.havitri.list4u.api.repository.ListRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Slf4j
class ListService {
    @Autowired
    ListRepository repository

    @Autowired
    CategoryRepository categoryRepository

    @Autowired
    ItemRepository itemRepository

    ListEntity get() {
        def lists = repository.findAll()
        def list
        if(lists.empty) {
            log.warn("Unable to locate list, creating a new one")
            list = repository.save(new ListEntity(name: "Grocery*"))
        }
        else {
            list = lists[0]
        }
        list
    }

    ListEntity addNewItemAndNewCategory(String categoryName, String name) {
        def list = get()
        def categoryEntity = categoryRepository.save(new CategoryEntity(name: categoryName))
        def itemEntity = itemRepository.save(new ItemEntity(name: name, category: categoryEntity))
        def listItemEntity = new ListItemEntity(item: itemEntity, list: list)
        list.items << listItemEntity
        repository.save(list)
    }

    ListEntity addNewItem(String newItemName, Long categoryId) {
        def list = get()
        def categoryEntity = categoryRepository.findById(categoryId).get()
        def itemEntity = itemRepository.save(new ItemEntity(name: newItemName, category: categoryEntity))
        def listItemEntity = new ListItemEntity(item: itemEntity, list: list)
        list.items << listItemEntity
        repository.save(list)
    }

    ListEntity addItem(Long itemId) {
        def list = get()
        def itemEntity = itemRepository.findById(itemId).get()
        def listItemEntity = new ListItemEntity(item: itemEntity, list: list)
        list.items << listItemEntity
        repository.save(list)
    }
}
