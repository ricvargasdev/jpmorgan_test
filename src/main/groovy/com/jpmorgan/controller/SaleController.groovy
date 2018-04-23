package com.jpmorgan.controller

import com.jpmorgan.utils.Constants
import com.jpmorgan.utils.MessageUtils
import com.jpmorgan.utils.StringUtils

/**
 * Handles the logic for <b>Sales</b>
 */
class SaleController {

    int messageNumber = 0
    Map sales = [:]
    Map adjustments = [:]

    void readMessage(String message){
        messageNumber++

        if(messageNumber == 50){
            println "== Message no. ${messageNumber}: PAUSING =="
            this.adjustmentsLog()
        }else if(messageNumber < 50){
            Map msg = MessageUtils.evaluate(message)
            switch(msg.msgType){
                case Constants.MESSAGE_TYPE_1:
                    sales = MessageUtils.messageType1(msg, sales)
                break
                case Constants.MESSAGE_TYPE_2:
                    sales = MessageUtils.messageType2(msg, sales)
                break
                case Constants.MESSAGE_TYPE_3:
                    adjustments[msg.key] = (adjustments[msg.key] ? adjustments[msg.key]+1 : 1)
                    sales = MessageUtils.messageType3(msg, sales)
                break
            }

            if(messageNumber % 10 == 0){
                this.reportLog()
            }

            println "=== ${message} ==="
            sales.each { entry ->
                println "Key: $entry.key"
                entry.value.each{
                    println it
                }
            }
            println "================"
        }
    }

    /**
     * Log a report detailing the number of sales of each product and their total value.
     */
    void reportLog(){
        Map report = [:]
        sales.each {
            String key = it.key
            Long totalQty = 0
            Long totalValue = 0
            it.value.each { productDetail ->
                totalQty += productDetail?.qty.toLong()
                totalValue += StringUtils.removeLastChar(productDetail?.price).toLong()
            }

            report.put(key, [qty:totalQty, price:totalValue])
        }

        println "=== Report ==="
        println report
    }

    /**
     * Log a report of the adjustments that have been made to each sale type while the application was running
     */
    void adjustmentsLog(){
        println "=> Number of Adjustments:"
        println adjustments
    }

}
