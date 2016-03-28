package net.infobosccoma.localitzacio.presenter.impl;

import net.infobosccoma.localitzacio.model.business.entities.Localitzacio;
import net.infobosccoma.localitzacio.model.persistence.daos.impl.LocalitzacioRESTDAO;
import net.infobosccoma.localitzacio.model.persistence.daos.interfaces.LocalitzacioDAO;
import net.infobosccoma.localitzacio.presenter.interficie.MainViewPresenter;
import net.infobosccoma.localitzacio.view.impl.activities.Base;

import java.util.List;

/**
 * Created by Kevin on 25/03/2016.
 */
public class MainViewLocalitzacio implements MainViewPresenter {

    private Base view;
    private List<Localitzacio> localitzacioList;
    private LocalitzacioDAO localitzacioDAO;


    @Override
    public void onCreate(Base view) {
        this.view = view;
        localitzacioDAO = new LocalitzacioRESTDAO(view);
    }

    @Override
    public void getLocalitzacioFromService() {
        localitzacioList = localitzacioDAO.getAll();
    }

    @Override
    public void getLocalitzacioById(String localitzacio) {
        localitzacioList = localitzacioDAO.getById(localitzacio);
    }
}
