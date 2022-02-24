package qx.leizige.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 用 Groovy 的 GroovyClassLoader ，动态地加载一个脚本并执行它的行为。
 * GroovyClassLoader是一个定制的类装载器，负责解释加载Java类中用到的Groovy类
 * </p>
 */
public class GroovyClassLoaderExample {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

        @SuppressWarnings("all")
        Class clazz = groovyClassLoader.parseClass(new File("simple-example/src/main/resources/Student.groovy"));

        GroovyObject groovyObject = (GroovyObject) clazz.newInstance();

        groovyObject.invokeMethod("setName", "张三");
        groovyObject.invokeMethod("setAge", 20);

        System.err.println(groovyObject.invokeMethod("toString", null));

    }
}
