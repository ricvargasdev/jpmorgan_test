package com.jpmorgan.utils

import com.jpmorgan.utils.Constants
import com.jpmorgan.utils.MessageUtils
import spock.lang.Specification

/**
 * Test file for <b>MessageUtils</b>
 */
final class MessageUtilsTest extends Specification {

    def "evaluate returns [:]"(){
        setup:
        MessageUtils.evaluate("message")

        when:
        MessageUtils.evaluate("message")

        then:
        [msgType: Constants.MESSAGE_TYPE_INVALID]
    }

    def "messageType1 returns [:]"(){
        setup:
        MessageUtils.messageType1([:], [:])

        when:
        MessageUtils.messageType1([key:"apple", price:"10p", qty:1], [:])

        then:
        [apple:[[key:"apple", qty:1, price:"10p"]]]
    }

    def "messageType2 returns [:]"(){
        setup:
        MessageUtils.messageType2([:], [:])

        when:
        MessageUtils.messageType2([key:"apple", price:"10p", qty:20], [:])

        then:
        [apple:[[key:"apple", price:"10p", qty:20]]]
    }

    def "messageType3 returns [:]"(){
        setup:
        MessageUtils.messageType3([:], [:])

        when:
        MessageUtils.messageType3([key:"apple", price:"10p", operator:"add"], [apple:[[key:"apple", qty:1, price:"10p"]]])

        then:
        [apple:[[key:"apple", qty:1, price:"20p"]]]
    }
}
