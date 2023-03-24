package com.chinhnd.security.common;

public class Constrants {

    public static class CommonEntityECColumn {
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
    }

    public static class Message {
        public static final String VALIDATE_MAX_SIZE_60 = "No more than 60 characters";
        public static final String VALIDATE_THE_FIELD = "The field can't empty";
    }

    // maxlength
    public static final int MAX_60 = 60;

    // status code response
    public static final int HTTP_CODE_200 = 200;
    public static final int HTTP_CODE_400 = 400;
    public static final int HTTP_CODE_401 = 401;
    public static final int HTTP_CODE_403 = 403;
    public static final int HTTP_CODE_404 = 404;
    public static final int HTTP_CODE_500 = 500;

    // status response
    public static final String SUCCESS = "Success get information record";

}
