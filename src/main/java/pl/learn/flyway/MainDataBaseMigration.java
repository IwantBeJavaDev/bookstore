package pl.learn.flyway;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainDataBaseMigration {
    ResourceBundle rb = ResourceBundle.getBundle("application");

    public static void main(String[] args) {
        MainDataBaseMigration mainClass = new MainDataBaseMigration();
        Properties properties = mainClass.readProperties();

        Flyway flyway = Flyway.configure().dataSource(properties.getProperty("spring.flyway.url"),
                                                      properties.getProperty("spring.flyway.user"),
                                                      properties.getProperty("spring.flyway.password"))
                                                      .load();
        flyway.migrate();
    }

    public Properties readProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream inputStream = loader.getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
