package lucas.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author Lucas Campos
 */
@SpringBootApplication
@EnableConfigServer
@EnableConfigurationProperties
public class SpringConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigurationApplication.class, args);
	}

    @Value("${configuration.projectName}")
	void atValue(String projectName) {
        System.out.println("@Valeu = The name of this project is: " + projectName);
    }

    @Autowired
    void configurationWithEnvironment(Environment environment) {
        System.out.println(String.format("Environment = The version is %s", environment.getProperty("object.year")));
    }

    @Autowired
    void configurationBindingObject(ObjectConfiguration configuration) {
        System.out.println(String.format("Binding object = Name: %s and year: %d", configuration.getName(), configuration.getYear()));
    }

}
