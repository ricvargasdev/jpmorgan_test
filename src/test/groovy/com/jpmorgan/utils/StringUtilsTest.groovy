package com.jpmorgan.utils
import spock.lang.Specification

/**
 * Test file for <b>StringUtils</b>
 */
final class StringUtilsTest extends Specification {
    def "removeLastChar returns tes"(){
        setup:
        // StringUtils.removeLastChar("test")
        StringUtils

        when:
        String result = StringUtils.removeLastChar("test")

        then:
        result == "tes"
    }
}
