package com.squishydev.setoz.englishkidstalk.data.network;

import com.squishydev.setoz.englishkidstalk.Config;

/**
 * Created by miftahun on 10/6/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class Endpoint {
    //SUMMARY
    public static final String ENDPOINT_REGISTER_USERS = Config.BASE_URL_API
            + "auth/register";

    public static final String ENDPOINT_LOGIN_USERS = Config.BASE_URL_API
            + "auth/login";

    public static final String ENDPOINT_QUESTION_CATEGORIES = Config.BASE_URL_API
            + "question-categories";

    public static final String ENDPOINT_USER_PROFILE = Config.BASE_URL_API
            + "users/";

    public static final String ENDPOINT_LEARNING_ITEMS = Config.BASE_URL_API
            + "learning-items";

    public static final String ENDPOINT_CHALLENGESS = Config.BASE_URL_API
            + "challenges";

    public static final String ENDPOINT_INVETORIES = Config.BASE_URL_API
            + "inventories/";

    public static final String ENDPOINT_ACTIVATE_ITEM = Config.BASE_URL_API
            + "inventories/activate-item";

    public static final String ENDPOINT_DEACTIVATE_ITEM = Config.BASE_URL_API
            + "inventories/activate-item";

    public static final String ENDPOINT_ITEM_CATEGORIES = Config.BASE_URL_API
            + "item-categories";

    public static final String ENDPOINT_GET_ITEMS = Config.BASE_URL_API
            + "items";
}
