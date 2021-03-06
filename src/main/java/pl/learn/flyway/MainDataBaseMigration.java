package pl.learn.flyway;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainDataBaseMigration {


    public static final String FLYWAY_PROD = "flyway.";
    public static final String FLYWAY_DEV = "flyway.dev.";
    public static final String PRODUCTION = "production";
    public static final String DEV = "dev";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.printf("Set parameter: %1$s or %2$s", PRODUCTION, DEV);
            return;
        }

        MainDataBaseMigration mainClass = new MainDataBaseMigration();
        Properties properties = mainClass.readProperties();
        if (args[0].equalsIgnoreCase(PRODUCTION)) {
            mainClass.runMigrationInProductionDataBase(properties);
        } else if (args[0].equalsIgnoreCase(DEV)) {
            mainClass.runMigrationInDevDataBase(properties);
        } else {
            System.out.printf("Not supported parameter use %1$s or %2$s", PRODUCTION, DEV);
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
        try (InputStream inputStream = loader.getResourceAsStream("db/flyway.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
