package qx.leizige.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

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
