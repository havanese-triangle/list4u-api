package com.havitri.list4u.api.service

import com.havitri.list4u.api.entity.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListService {
    @Autowired
    ListRepository repository

    @Autowired
    CategoryRepository categoryRepository

    @Autowired
    ItemRepository itemRepository

    ListEntity get() {
        def lists = repository.findAll()
        lists.empty ? repository.save(new ListEntity(name: "Grocery")) : lists[0]
    }

    ListEntity addItem(Long listId, String categoryName, String name) {
        def listOptional = repository.findById(listId)
        def list = listOptional.orElse(repository.save(new ListEntity(name: "Grocery*")))
        def categoryEntity = categoryRepository.save(new CategoryEntity(name: categoryName))
        def itemEntity = itemRepository.save(new ItemEntity(name: name, category: categoryEntity))
        def listItemEntity = new ListItemEntity(item: itemEntity, list: list)
        list.items << listItemEntity
        repository.save(list)
    }
}
