package pl.learn.flyway;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.Properties;

public class MainDataBaseMigrationTest {
    @Test
    public void whenReadProperiesFile_thenGetDataBaseParam() {
        //given
        MainDataBaseMigration mainClass = new MainDataBaseMigration();
        //when
        Properties properties = mainClass.readProperties();
        //then
        assertThat(properties.getProperty(MainDataBaseMigration.FLYWAY_PROD + "password")).isEqualTo("test");
        assertThat(properties.getProperty(MainDataBaseMigration.FLYWAY_PROD + "user")).isEqualTo("test");
        assertThat(properties.getProperty(MainDataBaseMigration.FLYWAY_PROD + "url")).isEqualTo("jdbc:postgresql://localhost:5432/learn");
        //then - read dev properties
        assertThat(properties.getProperty(MainDataBaseMigration.FLYWAY_DEV + "password")).isEqualTo("test");
        assertThat(properties.getProperty(MainDataBaseMigration.FLYWAY_DEV + "user")).isEqualTo("test");
        assertThat(properties.getProperty(MainDataBaseMigration.FLYWAY_DEV + "url")).isEqualTo("jdbc:postgresql://localhost:5432/learn_test");

    }


}
