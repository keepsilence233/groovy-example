package qx.leizige.groovy.datatype

/**
 * Groovy GString DataType example*/
class GStringExample {


    static void testGString(){
        //简单的$语法
        def me = 'Tarzan'
        def you = 'Jane'
        def line = "me $me - you $you"
        assert line == "me Tarzan - you Jane"

        //扩展的简单语言
        def date = new Date(0);
        def out = "Year $date.year Month $date.month Day $date.date"
        assert out == 'Year 70 Month 0 Day 1'

        //使用花括号标识的完整语法
        //在花括号中可以是任意的groovy表达式，花括号表示一个闭包
        out = "Data is ${date.toGMTString()}"
        assert out == 'Data is 1 Jan 1970 00:00:00 GMT'

        //多行的GString
        def querySql = """
        select * from MyTable 
        where year = $date.year
        """
        assert querySql == """
        select * from MyTable 
        where year = 70
        """

        //$符号作为字符串的一部分
        out = "my 0.02\$"
        assert out == 'my 0.02$'
    }


    /**
     * 使用StringBuffer修改字符串
     */
    static void modifyStringText(){
        def greeting = 'Hello'
        greeting <<= ' Groovy'  //在Hello后面追加文本并赋值
        assert greeting instanceof StringBuffer
        greeting <<= '!' //在StringBuffer后面追加文件
        assert greeting.toString() == 'Hello Groovy!'
        greeting[1..4] = 'i' //将子字符串'ello'替换为'i'
        assert greeting.toString() == 'Hi Groovy!'
    }

    static void main(String[] args) {
        testGString()
        modifyStringText()
    }


}
