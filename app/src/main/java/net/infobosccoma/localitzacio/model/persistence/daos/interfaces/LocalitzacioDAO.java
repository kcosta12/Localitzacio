package net.infobosccoma.localitzacio.model.persistence.daos.interfaces;

import net.infobosccoma.localitzacio.model.business.entities.Localitzacio;

import java.util.List;

/**
 * Created by Kevin on 25/03/2016.
 */
public interface LocalitzacioDAO {

    List<Localitzacio> getById(final String id);
    List<Localitzacio> getAll();
}
