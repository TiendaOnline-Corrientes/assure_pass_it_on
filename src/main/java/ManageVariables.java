import api.AppProperties;

import java.util.Optional;

public class ManageVariables {

    public static String getHost(){
        return Optional.ofNullable(System.getenv("host")).
                orElse((String) AppProperties.loadProperties().get("host"));
    }

    public static String getPath(){
        return Optional.ofNullable(System.getenv("path_api")).
                orElse((String) AppProperties.loadProperties().get("path_api"));
    }

    public static String getPrimarilyPath(){
        return Optional.ofNullable(System.getenv("path_primarily")).
                orElse((String) AppProperties.loadProperties().get("path_primarily"));
    }
}
