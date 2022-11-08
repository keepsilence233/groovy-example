package qx.leizige.groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;

/**
 * <p>
 * GroovyShell多用于推求对立的脚本或表达式，如果换成相互关联的多个脚本，使用GroovyScriptEngine会更好些。
 * GroovyScriptEngine从您指定的位置（文件系统，URL，数据库，等等）加载Groovy脚本，并且随着脚本变化而重新加载它们。
 * 如同GroovyShell一样，GroovyScriptEngine也允许您传入参数值，并能返回脚本的值。
 * </p>
 */
public class GroovyScriptEngineExample {

    public static void main(String[] args) throws IOException, ScriptException, ResourceException {
        GroovyScriptEngine gse = new GroovyScriptEngine("simple-example/src/main/resources/");
        Binding binding = new Binding();
        binding.setVariable("body","param body ......");
        gse.run("script_test.groovy",binding);
    }
}
