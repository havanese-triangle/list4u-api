package com.havitri.list4u.api

import com.havitri.list4u.api.grocery.GroceryItem
import spock.lang.Specification

class GroceryListSpec extends Specification {

    def "nothing interesting"() {
        given:
        def item = new GroceryItem()

        when:
        item.id = 1
        item.name = "Pizza"

        then:
        item.name == "Pizza"
    }
}
