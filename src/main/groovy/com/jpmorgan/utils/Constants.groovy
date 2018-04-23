package com.jpmorgan.utils

/**
 * Application constants
 */
final class Constants {
    static final int MESSAGE_TYPE_INVALID = 0

    static final int MESSAGE_TYPE_1 = 1
    static final int MESSAGE_TYPE_1_SIZE = 3

    static final int MESSAGE_TYPE_2 = 2
    static final int MESSAGE_TYPE_2_SIZE = 7

    static final int MESSAGE_TYPE_3 = 3
    static final int MESSAGE_TYPE_3_SIZE = 3

    static final ADD = "add"
    static final SUBSTRACT = "substract"
    static final MULTIPLY = "multiply"

    static final Collection<String> MESSAGE_INSTRUCTIONS = [ADD, SUBSTRACT, MULTIPLY]
}
