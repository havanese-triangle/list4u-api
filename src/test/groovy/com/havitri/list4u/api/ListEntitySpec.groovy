package com.havitri.list4u.api

import com.havitri.list4u.api.entity.ItemEntity
import spock.lang.Specification

class ListEntitySpec extends Specification {

    def "nothing interesting"() {
        given:
        def item = new ItemEntity()

        when:
        item.id = 1
        item.name = "Pizza"

        then:
        item.name == "Pizza"
    }
}
