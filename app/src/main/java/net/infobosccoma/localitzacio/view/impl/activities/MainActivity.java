package net.infobosccoma.localitzacio.view.impl.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import net.infobosccoma.localitzacio.R;
import net.infobosccoma.localitzacio.model.business.entities.Localitzacio;
import net.infobosccoma.localitzacio.presenter.impl.MainViewLocalitzacio;
import net.infobosccoma.localitzacio.presenter.interficie.MainViewPresenter;

import java.util.List;

public class MainActivity extends Base implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private MainViewPresenter presenter;
    private EditText editText;
    private ListLocalitzacioListener localitzacioListener;
    private List<Localitzacio> list;
    private Button button;
    private UiSettings uiSettings;
    private String text;

    private static final LatLng INS_BOSC_DE_LA_COMA = new LatLng(42.1727, 2.47631);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        localitzacioListener = new ListLocalitzacioListener();
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.buttonCercar);
        presenter = new MainViewLocalitzacio();
        presenter.onCreate(MainActivity.this);
        button.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
//        mMap.addMarker(new MarkerOptions()
//                .position(INS_BOSC_DE_LA_COMA)
//                .title("INS BOSC DE LA COMA")
//                .snippet("Estudi: ESO, Batxillerat, Cicles Formatius i CAS"));
//        LatLng sydney = new LatLng(42.181, 2.4901);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public RequestListener<?> getListListenner() {
        return localitzacioListener;
    }

    @Override
    public RequestListener<?> getUpdateListener() {
        return null;
    }

    @Override
    protected void onStart() {
        presenter.getLocalitzacioFromService();
        super.onStart();
    }

    @Override
    public void onClick(View view) {
        text = editText.getText().toString().trim().toLowerCase();
        presenter.getLocalitzacioById(text);

        if (text.trim().toUpperCase().equals("OLOT")) {
            mMap.clear();
            LatLng olot = new LatLng(42.181, 2.4901);
            mMap.addMarker(new MarkerOptions().position(olot).title("Olot")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .snippet("Olot"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(olot, 13));
        } else if (text.trim().toUpperCase().equals("BANYOLES")) {
            mMap.clear();
            LatLng banyoles = new LatLng(42.1167, 2.7667);
            mMap.addMarker(new MarkerOptions().position(banyoles).title("Banyoles")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .snippet("Banyoles"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(banyoles, 13));
        } else if (text.trim().toUpperCase().equals("BARCELONA")) {
            mMap.clear();
            LatLng barcelona = new LatLng(41.3850595, 2.173406699999987);
            mMap.addMarker(new MarkerOptions().position(barcelona).title("Barcelona")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .snippet("Barcelona"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(barcelona, 13));
        } else {
            presenter.getLocalitzacioById(text);
        }
    }

    public final class ListLocalitzacioListener implements RequestListener<Localitzacio.Llista> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(MainActivity.this, "No trobat", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(Localitzacio.Llista puntsInteres) {
            mMap.clear();
            LatLng latLng;
            Toast.makeText(MainActivity.this, "Acabat", Toast.LENGTH_SHORT).show();
            for (Localitzacio p : puntsInteres) {
                latLng = new LatLng(p.getLatitude(), p.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(p.getName()));
            }

        }

    }
}

