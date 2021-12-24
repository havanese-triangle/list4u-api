package com.havitri.list4u.api.controller


import com.havitri.list4u.api.service.ListService
import com.havitri.list4u.api.view.ItemAdd
import com.havitri.list4u.api.view.ListView
import groovy.json.JsonGenerator
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
