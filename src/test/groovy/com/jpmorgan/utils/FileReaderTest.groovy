package com.jpmorgan.utils

import com.jpmorgan.utils.FileReader
import spock.lang.Specification

/**
 * Test file for <b>FileReader</b>
 */
class FileReaderTest extends Specification {

    def "readMessage"(){
        setup:
        FileReader.readFile("file")

        when:
        FileReader.readFile("file")

        then:
        true
    }

}
