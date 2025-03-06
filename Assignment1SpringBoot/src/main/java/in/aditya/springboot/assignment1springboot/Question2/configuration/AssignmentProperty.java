package in.aditya.springboot.assignment1springboot.Question2.configuration;

import io.micrometer.common.lang.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "assignment")
public class AssignmentProperty {
    @NonNull
    private String myProperty;

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }
}