package com.havitri.list4u.api.view


import com.havitri.list4u.api.entity.ListEntity
import com.havitri.list4u.api.entity.ListRepository
import groovy.json.JsonGenerator
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
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
        if(!list.id) {
            log.warn("No lists found adding default 'Grocery' list")
            list = repository.save(list)
        }
        def json = jsonGenerator.toJson(list)
        json
    }

}
