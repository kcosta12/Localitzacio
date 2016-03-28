package net.infobosccoma.localitzacio.presenter.interficie;

import net.infobosccoma.localitzacio.view.impl.activities.Base;
import net.infobosccoma.localitzacio.view.impl.activities.MainActivity;

/**
 * Created by Kevin on 26/03/2016.
 */
public interface MainViewPresenter {

    void onCreate(Base view);
    void getLocalitzacioFromService();
    void getLocalitzacioById(String localitzacio);
}
