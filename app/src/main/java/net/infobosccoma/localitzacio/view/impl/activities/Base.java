package net.infobosccoma.localitzacio.view.impl.activities;

import android.support.v7.app.ActionBarActivity;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.request.listener.RequestListener;

import net.infobosccoma.localitzacio.network.LocalitzacioRetrofitSpiceService;

/**
 * Created by Kevin on 25/03/2016.
 */
public abstract class Base extends ActionBarActivity {

    private SpiceManager spiceManager = new SpiceManager(LocalitzacioRetrofitSpiceService.class);

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }

    public abstract RequestListener<?> getListListenner();

    public abstract RequestListener<?> getUpdateListener();
}