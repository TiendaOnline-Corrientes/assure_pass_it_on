package api;

import org.apache.logging.log4j.core.util.Loader;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

// vamos a leer los archivos
public class AppProperties {

    private static final String APP_PREFIX= "app";
    private static final String APP_SUFfIX = "properties";

    public  static Properties loadProperties(){
        //aca lo que me pasen por linea de comandos
        String environment = Optional.ofNullable(System.getenv("env")).
                                orElse("test");
        //concatenamos
        String fileName = String.format("%s-%s.%s",APP_PREFIX,environment,APP_SUFfIX);

        Properties prop = new Properties();

        try {
            prop.load(getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  prop;
    }
}
