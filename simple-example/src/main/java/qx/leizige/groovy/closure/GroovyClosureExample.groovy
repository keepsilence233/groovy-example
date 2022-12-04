package qx.leizige.groovy.closure

/**
 * Groovy 闭包
 * 闭包是一段逻辑块，可以直接把闭包作为参数到处传递，从方法调用返回闭包，或者存储起来后续使用
 */
class GroovyClosureExample {

    /**
     * 箭头是闭包的参数和代码的分隔指示符。方法的传递值给箭头左边参数，箭头的 右边是闭包的代码。*/
    static void main(String[] args) {
        //声明闭包
        def log = ''
        (1..10).each { log += it }
        assert log == '12345678910'

        //使用赋值的方式声明闭包
        def printer = { line -> print(line) }

        //引用一个方法作为闭包
        //引用一个方法作为闭包是使用 reference.&操作符，reference 是闭包调用时使用的对象实例
        MethodClosureSample first = new MethodClosureSample(6)
        MethodClosureSample second = new MethodClosureSample(5)
        Closure firstClosure = first.&validate

        def words = ['long string', 'medium', 'short', 'tiny']

        assert 'medium' == words.find(firstClosure)
        assert 'short' == words.find(second.&validate)

        //方法闭包运行时重载
        MultiMethodSample instance = new MultiMethodSample()
        Closure multi = instance.&mysteryMethod
        assert 10 == multi('string age')
        assert 2 == multi(['a', 'b'])
        assert 6 == multi(3, 3)


        //调用闭包
        //通过 x.call()来调用闭包，或者简单的 x()
        def adder = { x, y -> return x + y }
        assert adder(1, 2) == 3
        assert adder.call(2, 3) == 5

    }


    static class MethodClosureSample {
        int limit

        MethodClosureSample(int limit) {
            this.limit = limit
        }

        boolean validate(String value) {
            return value.length() <= limit
        }
    }


    static class MultiMethodSample {
        static int mysteryMethod(String value) {
            return value.length();
        }

        static int mysteryMethod(List list) {
            return list.size();
        }

        static int mysteryMethod(int x, int y) {
            return x + y
        }
    }
}
