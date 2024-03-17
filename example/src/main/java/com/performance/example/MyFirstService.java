package com.performance.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom2.properties")
})
public class MyFirstService {


    private MyFirstClass myFirstClass;

    @Value("Hello Performance Engineers")
    private String customProperty;

    @Value("123")
    private int customPropertyInt;

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    @Value("${my.prop.architect}")
    private String customPropertyFromAnotherFile2;

    public String getCustomPropertyForProfile() {
        return customPropertyForProfile;
    }

    @Value("${my.custom.property}")
    private String customPropertyForProfile;

    public MyFirstService( @Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public int getCustomPropertyInt() {
        return customPropertyInt;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    /*

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOSName() {
        return environment.getProperty("os.name");
    }

    public String readProp() {
        return environment.getProperty("my.custom.property");
    }


    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
     */
}
