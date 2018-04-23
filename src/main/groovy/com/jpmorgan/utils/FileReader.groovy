package com.jpmorgan.utils

/**
 * Utility class for reading files.
 */
final class FileReader {

    static final Collection readFile(String path){
        try{
            def file = new File(path)
            file.readLines().collect { it }
        }catch(FileNotFoundException fnfe){
            println "File not found: '${path}'"
            []
        }
    }

}
