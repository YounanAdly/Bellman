package com.example.android.bellman.Common;

import com.example.android.bellman.Remote.RetrofitClient;
import com.example.android.bellman.Service.BellmanService;

public class Common {

    private static final String BASE_URL = "http://bellman-bd.restart-technology.com/api/" ;


    public static BellmanService getBellmanService() {
        return RetrofitClient.getClient(BASE_URL).create(BellmanService.class);

    }


}
