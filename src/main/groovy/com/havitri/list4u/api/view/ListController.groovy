package com.havitri.list4u.api.view

import com.havitri.list4u.api.entity.CategoryEntity
import com.havitri.list4u.api.entity.CategoryRepository
import com.havitri.list4u.api.entity.ItemEntity
import com.havitri.list4u.api.entity.ItemRepository
import com.havitri.list4u.api.entity.ListEntity
import com.havitri.list4u.api.entity.ListItemEntity
import com.havitri.list4u.api.entity.ListRepository
import com.havitri.list4u.api.service.ListService
import groovy.json.JsonGenerator
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
class ListController {

    @Autowired
    ListService listService

    JsonGenerator jsonGenerator = new JsonGenerator.Options()
            .excludeNulls()
            .build()

    @GetMapping("/")
    String getList() {
        def list = listService.get()
        def listView = ListView.from(list)
        def json = jsonGenerator.toJson(listView)
        json
    }

    @PostMapping("/list/{id}/item")
    String addItem(@PathVariable Long id, @RequestBody ItemAdd item) {
        log.info("Adding item to list $id")
        def list = listService.addItem(id, item.categoryName, item.name)
        def listView = ListView.from(list)
        def json = jsonGenerator.toJson(listView)
        json
    }

}
