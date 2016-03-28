package net.infobosccoma.localitzacio.network;


import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import net.infobosccoma.localitzacio.model.business.entities.Localitzacio;

/**
 * Created by Kevin on 25/03/2016.
 */
public class LocalitzacioRetrofitSpiceRequest  extends RetrofitSpiceRequest<Localitzacio.Llista, LocalitzacioAPI>{

    public LocalitzacioRetrofitSpiceRequest() {
        super(Localitzacio.Llista.class, LocalitzacioAPI.class);
    }

    @Override
    public Localitzacio.Llista loadDataFromNetwork() throws Exception {
        return getService().getAll();
    }

    public Localitzacio.Llista loadDataFromNetworkByName(String id){
        return getService().getLocalitzacioById(id);
    }
}
