package qx.leizige.groovy.example;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/scriptHandler")
public class GroovyScriptHandler implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * http://localhost:8080/scriptHandler/executeBindingService/1+1
     * http://localhost:8080/scriptHandler/executeBindingService/defaultCalculatorImpl.add(1,2)
     * http://localhost:8080/scriptHandler/executeBindingService/defaultCalculatorImpl.getNumber()
     *
     * @param scriptText groovy shell
     * @return execute groovy shell result
     */
    @GetMapping(value = "/executeBindingService/{scriptText}")
    public ResponseEntity<Object> executeBindingService(@PathVariable String scriptText) {

        if (StringUtils.isEmpty(scriptText)) {
            return ResponseEntity.ok(HttpStatus.OK);
        }

        GroovyShell groovyShell = new GroovyShell();
        Script script = groovyShell.parse(scriptText);

        Binding groovyBinding = new Binding();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(name -> {
            groovyBinding.setVariable(name, applicationContext.getBean(name));
        });

        script.setBinding(groovyBinding);
        return ResponseEntity.ok(script.run());
    }


    @Configuration
    public static class ScriptConfiguration {
        @Bean
        @ConditionalOnMissingBean
        public ICalculator calculator() {
            return new DefaultCalculatorImpl();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
