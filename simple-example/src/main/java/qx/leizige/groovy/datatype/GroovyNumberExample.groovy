package qx.leizige.groovy.datatype

/**
 * GDK 为数字提供的方法
 */
class GroovyNumberExample {

    static void main(String[] args) {

        //重复
        def store = ''
        10.times {
            store += 'x'
        }
        assert  store == 'xxxxxxxxxx'

        //使用循环变量向上移动
        store = ''
        1.upto(5,{
            store += it
        })
        assert store == '12345'

        //循环向下
        store = ''
        2.downto(-2,{
            store += it + '  '
        })
        assert store == '2  1  0  -1  -2  '


        store = ''
        0.step(0.5,0.1,{
            store +=it + '  '
        })
        assert store == '0  0.1  0.2  0.3  0.4  '
    }
}
