package com.havitri.list4u.api.view

import com.havitri.list4u.api.entity.ItemEntity
import com.havitri.list4u.api.entity.ItemRepository
import com.havitri.list4u.api.entity.ListEntity
import com.havitri.list4u.api.entity.ListRepository
import groovy.json.JsonGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ListController {

    @Autowired
    ListRepository repository

    JsonGenerator jsonGenerator = new JsonGenerator.Options()
            .excludeNulls()
            .excludeFieldsByName("mines")
            .build()

    @GetMapping("/")
    String getList() {
        def lists = repository.findAll()
        def list = lists.empty ? new ListEntity(name: "Grocery") : lists[0]
        def json = jsonGenerator.toJson(list)
        json
    }

}
