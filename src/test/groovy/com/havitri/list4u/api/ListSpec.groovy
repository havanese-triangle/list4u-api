package com.havitri.list4u.api

import com.havitri.list4u.api.Item
import spock.lang.Specification

class ListSpec extends Specification {

    def "nothing interesting"() {
        given:
        def item = new Item()

        when:
        item.id = 1
        item.name = "Pizza"

        then:
        item.name == "Pizza"
    }
}
