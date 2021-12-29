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

    @GetMapping(value = "/", produces = "application/json")
    String getList() {
        def list = listService.get()
        def listView = ListView.from(list)
        def json = jsonGenerator.toJson(listView)
        json
    }

    @PostMapping("/list/{id}/item")
    String addItem(@PathVariable Long id, @RequestBody ItemAdd item) {
        log.info("Adding item to list $id")
        log.warn("'id' is currently being ignored since there is only one list")
        def list
        if(item.itemId) {
            list = listService.addItem(item.itemId)
        }
        else if(item.categoryId) {
            list = listService.addNewItem(item.name, item.categoryId)
        }
        else {
            list = listService.addNewItemAndNewCategory(item.categoryName, item.name)
        }
        def listView = ListView.from(list)
        def json = jsonGenerator.toJson(listView)
        json
    }

    @DeleteMapping("/list/{id}/item/{itemId}")
    String removeItem(@PathVariable Long id, @PathVariable Long itemId) {
        log.info("Removing item ${itemId} from list $id")
        def list = listService.removeItem(itemId)
        def listView = ListView.from(list)
        def json = jsonGenerator.toJson(listView)
        json
    }
}
