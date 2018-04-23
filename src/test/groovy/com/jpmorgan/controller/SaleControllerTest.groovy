package com.jpmorgan.controller

import com.jpmorgan.utils.Constants
import com.jpmorgan.utils.MessageUtils
import com.jpmorgan.utils.StringUtils

import spock.lang.Specification

/**
 * Test file for <b>SaleController</b>
 */
class SaleControllerTest extends Specification {

    def "readMessage"(){
        setup:
        def saleController = new SaleController()

        when:
        saleController.readMessage("message")

        then:
        true
    }

    def "reportLog"(){
        setup:
        def saleController = new SaleController()

        when:
        saleController.reportLog()

        then:
        true
    }

    def "adjustmentsLog"(){
        setup:
        def saleController = new SaleController()

        when:
        saleController.adjustmentsLog()

        then:
        true
    }


}
