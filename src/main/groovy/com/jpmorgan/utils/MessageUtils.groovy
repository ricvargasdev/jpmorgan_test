package com.jpmorgan.utils

import com.jpmorgan.utils.Constants
import com.jpmorgan.utils.StringUtils

/**
 * Utility class to handle incoming messages.
 */
final class MessageUtils {

    static final Map evaluate(String msg){
        List<String> msgInstructions = msg.trim().split(" +")

        if(msgInstructions.size() == Constants.MESSAGE_TYPE_1_SIZE){
            if(msgInstructions[1].equalsIgnoreCase('at')){
                return [
                    msgType: Constants.MESSAGE_TYPE_1,
                    key:msgInstructions[0],
                    qty:1,
                    price:msgInstructions[2]
                ]
            }
        }
        if(msgInstructions.size() == Constants.MESSAGE_TYPE_2_SIZE){
            if(msgInstructions[2].equalsIgnoreCase('of') && msgInstructions[4].equalsIgnoreCase('at')){
                return [
                    msgType: Constants.MESSAGE_TYPE_2,
                    key:StringUtils.removeLastChar(msgInstructions[3]),
                    qty:msgInstructions[0],
                    price:msgInstructions[5]
                ]
            }
        }
        if(msgInstructions.size() == Constants.MESSAGE_TYPE_3_SIZE){
            if(msgInstructions[0].toLowerCase() in Constants.MESSAGE_INSTRUCTIONS){
                return [
                    msgType: Constants.MESSAGE_TYPE_3,
                    operator:msgInstructions[0].toLowerCase(),
                    key:StringUtils.removeLastChar(msgInstructions[2]),
                    price:msgInstructions[1]
                ]
            }
        }
        return [msgType: Constants.MESSAGE_TYPE_INVALID]
    }

    static final Map messageType1(Map msg, Map map){
        if(map.containsKey(msg.key)){
            map[msg.key].add([key:msg.key, price:msg.price, qty:msg.qty])
        }else{
            map.put(msg.key, [[key:msg.key, price:msg.price, qty:msg.qty]])
        }
        map
    }

    static final Map messageType2(Map msg, Map map){
        if(map.containsKey(msg.key)){
            map[msg.key].add([key:msg.key, price:msg.price, qty:msg.qty])
        }else{
            map.put(msg.key, [[key:msg.key, price:msg.price, qty:msg.qty]])
        }
        map
    }

    static final Map messageType3(Map msg, Map map){
        if(map.containsKey(msg.key)){
            map[msg.key].each {
                String oldPrice = it["price"]
                long newPrice = 0

                if(msg["operator"].equalsIgnoreCase(Constants.ADD)){
                    newPrice =  StringUtils.removeLastChar(oldPrice).toLong() + StringUtils.removeLastChar(msg["price"]).toLong()

                }else if(msg["operator"].equalsIgnoreCase(Constants.SUBSTRACT)){
                    newPrice =  StringUtils.removeLastChar(oldPrice).toLong() - StringUtils.removeLastChar(msg["price"]).toLong()

                }else if(msg["operator"].equalsIgnoreCase(Constants.MULTIPLY)){
                    newPrice =  StringUtils.removeLastChar(oldPrice).toLong() * StringUtils.removeLastChar(msg["price"]).toLong()
                }

                it["price"] = "${newPrice}p"
            }
        }
        map
    }

}
