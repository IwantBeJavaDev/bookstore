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
        assertThat(properties.getProperty("spring.flyway.password")).isEqualTo("test");
        assertThat(properties.getProperty("spring.flyway.user")).isEqualTo("test");
        assertThat(properties.getProperty("spring.flyway.url")).isEqualTo("jdbc:postgresql://localhost:5432/learn");
    }
}
