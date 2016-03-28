package net.infobosccoma.localitzacio.network;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

/**
 * Created by Kevin on 25/03/2016.
 */
public class LocalitzacioRetrofitSpiceService extends RetrofitGsonSpiceService {

    private final static String URL = "http://www.infobosccoma.net/pmdm/pois/v1/";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(LocalitzacioAPI.class);
    }

    @Override
    protected String getServerUrl() {
        return URL;
    }
}
