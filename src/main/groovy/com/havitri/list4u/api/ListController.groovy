package com.havitri.list4u.api


import groovy.json.JsonGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ListController {
    JsonGenerator jsonGenerator = new JsonGenerator.Options()
            .excludeNulls()
            .excludeFieldsByName("mines")
            .build()

    @GetMapping("/list")
    String getGame() {
        def list = [ new Item(id: 1, name: "Item")]
        def json = jsonGenerator.toJson(list)
        json
    }

}
