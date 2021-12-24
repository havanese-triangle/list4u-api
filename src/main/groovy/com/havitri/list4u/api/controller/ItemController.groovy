package com.havitri.list4u.api.controller

import com.havitri.list4u.api.entity.ItemEntity
import com.havitri.list4u.api.repository.ItemRepository
import com.havitri.list4u.api.view.ItemsView
import groovy.json.JsonGenerator
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
class ItemController {

    @Autowired
    ItemRepository itemRepository

    JsonGenerator jsonGenerator = new JsonGenerator.Options()
            .excludeNulls()
            .build()

    @GetMapping("/items")
    String getList() {
        def items = itemRepository.findAll()
        def itemsView = ItemsView.from(items as List<ItemEntity>)
        def json = jsonGenerator.toJson(itemsView)
        json
    }

}
