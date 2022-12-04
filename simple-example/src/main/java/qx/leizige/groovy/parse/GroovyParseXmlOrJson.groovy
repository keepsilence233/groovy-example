package qx.leizige.groovy.parse

import groovy.json.JsonSlurper
import groovy.xml.XmlSlurper

/**
 * Groovy 通过GPath 解析xml和json
 */
class GroovyParseXmlOrJson {
    static void main(String[] args) {
        def customers = new XmlSlurper().parse(new File("/Users/chinese.youth/temp1/groovy.xml"))
        for (customer in customers.corporate.customer) {
            println "${customer.@name} works for ${customer.@company}"
        }


        def json = new JsonSlurper().parse(new File("/Users/chinese.youth/temp1/groovy.json"))
        for (len in json.testLength) {
            println len?.xx
            println len.length
        }
    }
}