package com.havitri.list4u.api.view

import com.havitri.list4u.api.entity.CategoryEntity
import com.havitri.list4u.api.entity.CategoryRepository
import com.havitri.list4u.api.entity.ItemEntity
import com.havitri.list4u.api.entity.ItemRepository
import com.havitri.list4u.api.entity.ListEntity
import com.havitri.list4u.api.entity.ListItemEntity
import com.havitri.list4u.api.entity.ListRepository
import groovy.json.JsonGenerator
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import java.util.stream.Collectors

@Slf4j
@RestController
class ListController {

    @Autowired
    ListRepository repository

    @Autowired
    CategoryRepository categoryRepository

    @Autowired
    ItemRepository itemRepository

    JsonGenerator jsonGenerator = new JsonGenerator.Options()
            .excludeNulls()
            .build()

    @GetMapping("/")
    String getList() {
        def lists = repository.findAll()
        def list = lists.empty ? new ListEntity(name: "Grocery") : lists[0]
        if(!list.id) {
            log.warn("No lists found adding default 'Grocery' list")
            list = repository.save(list)
        }
        def json = jsonGenerator.toJson(list)
        json
    }

    @PostMapping("/list/{id}/item")
    String addItem(@PathVariable Long id, @RequestBody ItemAdd item) {
        log.info("Adding item to list $id")
        def listOptional = repository.findById(id)
        def list = listOptional.orElse(new ListEntity(name: "Grocery*"))
        def categoryEntity = categoryRepository.save(new CategoryEntity(name: item.categoryName))
        def itemEntity = itemRepository.save(new ItemEntity(name: item.name, category: categoryEntity))
        def listItemEntity = new ListItemEntity(item: itemEntity, list: list)
        list.items << listItemEntity
        list = repository.save(list)
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
        def json = jsonGenerator.toJson(listView)
        json
    }
}
