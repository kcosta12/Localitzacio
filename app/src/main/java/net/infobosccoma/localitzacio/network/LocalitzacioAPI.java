package net.infobosccoma.localitzacio.network;

import net.infobosccoma.localitzacio.model.business.entities.Localitzacio;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Kevin on 25/03/2016.
 */
public interface LocalitzacioAPI {

    @GET("/pois")
    Localitzacio.Llista getAll();

    @GET("/pois/{cityName}")
    Localitzacio.Llista getLocalitzacioById(@Path("cityName") String id);

}
