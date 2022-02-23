package qx.leizige.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

public class GroovyClassLoaderExample {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

        @SuppressWarnings("all")
        Class clazz = groovyClassLoader.parseClass(new File("simple-example/src/main/resources/Student.groovy"));

        GroovyObject groovyObject = (GroovyObject) clazz.newInstance();

        groovyObject.invokeMethod("setName", "张三");
        groovyObject.invokeMethod("setAge", 20);

        System.err.println(groovyObject.invokeMethod("toString",null));

    }
}
