package model.factory;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import schema.request.RequestUser;
import static model.builder.UserRequestBuilder.createRequestUser;

public class UserDataFactory {
    // con esto le vamos a dar diferentes formas


    static Faker dummyData =  new Faker();
    public static RequestUser missingData(){

        return createRequestUser().
                name(StringUtils.EMPTY).
                job(StringUtils.EMPTY).
                build();
    }

    public static RequestUser nullInformation(){
        return createRequestUser().
                name(null).
                job(null).
                build();
    }

    public static RequestUser validData(){
        return createRequestUser().
                name(dummyData.name().firstName()).
                job(dummyData.job().field()).
                build();
    }
}
