package pl.learn.flyway;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainDataBaseMigration {


    public static final String FLYWAY_PROD = "spring.flyway.";
    public static final String FLYWAY_DEV = "spring.flyway.dev.";

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Set parameter: dev or prodution");
            return;
        }

        MainDataBaseMigration mainClass = new MainDataBaseMigration();
        Properties properties = mainClass.readProperties();
        if (args[0].equalsIgnoreCase("production")) {
            mainClass.runMigrationInProductionDataBase(properties);
        } else if (args[0].equalsIgnoreCase("dev")) {
            mainClass.runMigrationInDevDataBase(properties);
        } else {
            System.out.println("Not supported parameter");
        }

    }


    public void runMigrationInProductionDataBase(Properties properties) {
        Flyway flyway = Flyway.configure().dataSource(properties.getProperty(FLYWAY_PROD + "url"),
                properties.getProperty(FLYWAY_PROD + "user"),
                properties.getProperty(FLYWAY_PROD + "password"))
                .load();
        flyway.migrate();
    }

    public void runMigrationInDevDataBase(Properties properties) {
        Flyway flyway = Flyway.configure().dataSource(properties.getProperty(FLYWAY_DEV + "url"),
                properties.getProperty(FLYWAY_DEV + "user"),
                properties.getProperty(FLYWAY_DEV + "password"))
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
