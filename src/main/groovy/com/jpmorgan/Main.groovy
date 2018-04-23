package com.jpmorgan

import com.jpmorgan.utils.FileReader
import com.jpmorgan.controller.SaleController

/**
  * Main entry class
  */
class Main {

    static void main(String[] args) {
        SaleController saleController = new SaleController()
        // Collection messages =  FileReader.readFile("sampleFiles/messages.txt")
        // Collection messages =  FileReader.readFile("sampleFiles/messages2.txt")
        Collection messages =  FileReader.readFile("sampleFiles/messages3.txt")

        messages.eachWithIndex { msg, idx ->
            // println "${idx}: ${msg}"
            saleController.readMessage(msg)
        }
    }
}
