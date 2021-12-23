package com.havitri.list4u.api.grocery


import groovy.json.JsonGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GroceryListController {

    @Autowired
    GroceryItemRepository itemRepository

    JsonGenerator jsonGenerator = new JsonGenerator.Options()
            .excludeNulls()
            .excludeFieldsByName("mines")
            .build()

    @GetMapping("/list")
    String getGame() {
        def list = [ new GroceryItem(id: 1, name: "Item")]
        def json = jsonGenerator.toJson(list)
        json
    }

    @GetMapping("/item")
    String getItem() {
        def item = itemRepository.save(new GroceryItem(name: "GENERATED"))
        jsonGenerator.toJson(item)
    }

}
