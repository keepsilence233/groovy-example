package qx.leizige.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * <p>
 * GroovyShell允许在Java类中（甚至Groovy类）求任意Groovy表达式的值。
 * 您可使用Binding对象输入参数给表达式，并最终通过GroovyShell返回Groovy表达式的计算结果。
 * </p>
 */
public class GroovyShellExample {
    public static void main(String[] args) {
        Binding binding = new Binding();
        binding.setVariable("x", 10);

        GroovyShell shell = new GroovyShell(binding);

        Object value = shell.evaluate("y = x *2; z = x * 3; return z");
        System.out.println("value = " + value);

        System.out.println("binding.getVariable(\"y\") = " + binding.getVariable("y"));

    }
}
