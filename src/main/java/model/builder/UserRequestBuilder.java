package model.builder;

import schema.request.RequestUser;

public class UserRequestBuilder {

    private RequestUser requestUser;

    private UserRequestBuilder() {
        this.requestUser = new RequestUser();
    }

    public static UserRequestBuilder createRequestUser(){
        return new UserRequestBuilder();
    }

    public UserRequestBuilder name(String name){
        this.requestUser.setName(name);
        return this;
    }

    public UserRequestBuilder job(String job){
        this.requestUser.setJob(job);
        return  this;
    }

    public RequestUser build(){
        return  requestUser;
    }

}
