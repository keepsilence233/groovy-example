package qx.leizige.groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;

public class GroovyScriptEngineExample {

    public static void main(String[] args) throws IOException, ScriptException, ResourceException {
        GroovyScriptEngine gse = new GroovyScriptEngine("simple-example/src/main/resources/");
        gse.run("script_test.groovy", new Binding());
    }
}
