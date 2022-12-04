package qx.leizige.groovy.datatype

/**
 * Groovy 集合类型*/
class GroovyCollectionExample {


    /**
     * 范围用两个点“..”表示范围操作符，用来指定从左边到右边的边界，这个操作符具 有较低的优先级，因此你常常需要使用圆括号把它们括起来，范围也可以通过相应的构造方 法进行声明。
     * “..<”范 围操作符号指定了一个半排除范围——也就是说，右边界值不是 range 的一 部分:*/
    static void GroovyRangeExample() {
//        left..right
//           (left..right)
        // (left..<rig ht)

        assert (0..10).contains(0)
        assert (0..10).contains(5)
        assert (0..10).contains(10)


        assert !(0..10).contains(-1)
        assert !(0..10).contains(11)


        def a = 0..10
        assert a instanceof Range
        assert a.contains(5)


        a = new IntRange(1, 3)
        assert a.contains(2)
//        assert (0.0..1.0).contains(0.5)

        //date range
//        def today = new Date()
//        def yesterday = today - 1
//        assert (yesterday..toString()).size() == 2

        //string range
        assert ('a'..'d').contains('b')

        //for in range loop
        def log = ''
        for (element in 5..9) {
            log += element
        }
        assert log == '56789'

        //loop with reverse range
        log = ''
        for (element in 9..5) {
            log += element
        }
        assert log == '98765'

        log = ''
        (9..<5).each { element ->
            {
                log += element
            }
        }
        assert log == '9876'


        //Ranges 对象
        def result = ''
        (5..9).each { element -> result += element
        }
        assert result == '56789'

        assert (0..10).isCase(5)

        //range switch
        def age = 36
        def insuranceRate
        switch (age) {
            case 16..20: insuranceRate = 0.05; break
            case 21..50: insuranceRate = 0.06; break
            case 51..60: insuranceRate = 0.07; break
            default: throw new IllegalArgumentException()
        }
        assert insuranceRate == 0.06

        def ages = [20, 36, 42, 56]
        def midage = 21..50
        assert ages.grep(midage) == [36, 32]

    }


    static void GroovyListExample() {

        //声明list
        def list = [1, 2, 3]
        assert list.size() == 3
        assert list[0] == 1
        assert list instanceof ArrayList

        def emptyList = []
        assert emptyList.size() == 0

        def longList = (0..1000).toList()
        assert longList[555] == 555

        //list 操作符
        list = ['a', 'b', 'c', 'd', 'e', 'f']
        assert list[0..2] == ['a', 'b', 'c']  //getAt(Range)
        assert list[0, 2, 4] == ['a', 'c', 'e'] //getAt(Collection of indexs)
        //putAt(Range)
        list[0..2] = ['x', 'y', 'z']
        assert list == ['x', 'y', 'z', 'd', 'e', 'f']
        //Remove element
        list[3..5] = []
        assert list == ['x', 'y', 'z']
        //add element
        list[1..1] = ['y', '1', '2']
        assert list == ['x', 'y', '1', '2', 'z']

        list = []
        list += 'a' //plus(Obj)
        assert list == ['a']

        list += ['b', 'c']
        assert list == ['a', 'b', 'c']

        //正向遍历
        list.each {
            {
                print it + ''
            }
        }
        println()
        //反向遍历
        list.reverseEach {
            {
                print it + ''
            }
        }
    }


    static void GroovyMapExample() {

        //声明map 通过“[:]”来声明一个空的map，map缺省的类型是java.util.HashMap
        //一般情况下key的类型都是字符串，在声明map的时候可以忽略字符串标记(单引号或 者双引号)
        def map = [a: 1, b: 2, c: 3]
        assert map instanceof HashMap
        assert map.size() == 3
        assert map['a'] == 1

        def emptyMap = [:]
        assert emptyMap.size() == 0

        def explicitMap = new TreeMap()
        explicitMap.putAll(map)
        assert explicitMap['a'] == 1


    }

    static void main(String[] args) {
//        GroovyRangeExample()
//        GroovyListExample()
        GroovyMapExample()
    }

}