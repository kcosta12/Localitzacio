package net.infobosccoma.localitzacio.model.persistence.daos.impl;

import android.content.Context;

import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import net.infobosccoma.localitzacio.model.business.entities.Localitzacio;
import net.infobosccoma.localitzacio.model.persistence.daos.interfaces.LocalitzacioDAO;
import net.infobosccoma.localitzacio.network.LocalitzacioAPI;
import net.infobosccoma.localitzacio.network.Response;
import net.infobosccoma.localitzacio.view.impl.activities.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 25/03/2016.
 */
public class LocalitzacioRESTDAO implements LocalitzacioDAO {

    private Context context;

    public LocalitzacioRESTDAO(Context context) {
        this.context = context;
    }

    @Override
    public List<Localitzacio> getById(final String id) {
        List<Localitzacio> localitzacioList = new ArrayList<>();
        RetrofitSpiceRequest<Localitzacio.Llista, LocalitzacioAPI> request =
                new RetrofitSpiceRequest<Localitzacio.Llista,
                        LocalitzacioAPI>(Localitzacio.Llista.class,
                        LocalitzacioAPI.class) {
                    @Override
                    public Localitzacio.Llista loadDataFromNetwork() throws Exception {
                        return getService().getLocalitzacioById(id);
                    }
                };
        ((Base) context).getSpiceManager().execute(request, "Localitzacio", DurationInMillis.ONE_MINUTE,
                (RequestListener<Localitzacio.Llista>)
                        ((Base) context).getListListenner());
        return localitzacioList;
    }

    /**
     * Obtenir tots els titulars.
     * Es fa una petició GET al servei REST
     *
     * @return
     */
    @Override
    public List<Localitzacio> getAll() {
        List<Localitzacio> localitzacioList = new ArrayList<>();
        RetrofitSpiceRequest<Localitzacio.Llista, LocalitzacioAPI> request =
                new RetrofitSpiceRequest<Localitzacio.Llista,
                        LocalitzacioAPI>(Localitzacio.Llista.class,
                        LocalitzacioAPI.class) {
                    @Override
                    public Localitzacio.Llista loadDataFromNetwork() throws Exception {
                        return getService().getAll();
                    }
                };
        ((Base) context).getSpiceManager().execute(request, "Localitzacio", DurationInMillis.ONE_MINUTE,
                (RequestListener<Localitzacio.Llista>)
                        ((Base) context).getListListenner());
        return null;
    }
}
