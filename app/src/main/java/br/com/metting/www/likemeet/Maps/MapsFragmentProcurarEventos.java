package br.com.metting.www.likemeet.Maps;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.metting.www.likemeet.Activitys.MainActivity;
import br.com.metting.www.likemeet.Adapters.EventosProcurarAdapter;
import br.com.metting.www.likemeet.Class.Evento;
import br.com.metting.www.likemeet.Fragments.InfoEventoMapFragment;
import br.com.metting.www.likemeet.Fragments.ListaEventoFragment;
import br.com.metting.www.likemeet.Fragments.ProcurarEventosMeetFragment;
import br.com.metting.www.likemeet.R;


public class MapsFragmentProcurarEventos extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "MapsFragmentProcurarEventos";
    private static final int MY_PERMISSION_LOCATION = 128;
    private LatLng local;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        getMapAsync(this);

        super.onCreate(savedInstanceState);

    }


    // executar alguma acao ao clicar em alguma area do meu mapa


    //sera executado quando o mapa estiver pronto
    @Override
    public void onMapReady(GoogleMap googleMap) {
        local = getMinhaLocalizacao();
        try {
            mMap = googleMap;
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.setMyLocationEnabled(true);
            marcarPontos();

            if (local != null) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 11));
            }

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    ArrayList<Evento> list = Evento.getListaEventosLatLong(marker.getPosition());
                    if (list.size() == 1) {
                        Fragment fragment = new InfoEventoMapFragment(list.get(0));

                        android.support.v4.app.FragmentTransaction fragmentTrasaction =
                                getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTrasaction.replace(R.id.LayoutBaixoMap, fragment);
                        fragmentTrasaction.commit();
                    }

                }
            });
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {// Inflate the layout for this fragment
                    chamarFragmentListaEventos(Evento.getListaEventosLatLong(marker.getPosition()));

                    // Se ela retorna falso, então o comportamento padrão irá ocorrer em adição ao seu comportamento personalizado
                    return false;
                }
            });

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    // se a lista for null entao ele retorna todos eventos
                    chamarFragmentListaEventos(null);

                }
            });
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        // criarRaio();
    }

    private void chamarFragmentListaEventos(ArrayList<Evento> lista) {


        // se a lista nao for nula , retornara todos eventos
        if (lista == null) {
            Fragment fragment = new ListaEventoFragment();
            android.support.v4.app.FragmentTransaction fragmentTrasaction =
                    getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTrasaction.replace(R.id.LayoutBaixoMap, fragment);
            fragmentTrasaction.commit();
            return;
        } else {
            // ser for size 1 quer diser que so ha 1 evento naquela localidade , entao abrimos a tela de ir para o evento diretamente
            if (lista.size() == 1) {
                Evento control = new Evento();

                Fragment fragment = new InfoEventoMapFragment(control.getEvento(lista.get(0).getId()));
                android.support.v4.app.FragmentTransaction fragmentTrasaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTrasaction.replace(R.id.LayoutBaixoMap, fragment);
                fragmentTrasaction.commit();
                return;

            }

            Fragment fragment = new ListaEventoFragment(lista);
            android.support.v4.app.FragmentTransaction fragmentTrasaction =
                    getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTrasaction.replace(R.id.LayoutBaixoMap, fragment);
            fragmentTrasaction.commit();
        }
    }

    private void marcarPontos() {

        MarkerOptions marker = new MarkerOptions();
        //    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marcar_map));

        for (Evento listaEvento : Evento.getListaEventos()) {
            String[] latlong = listaEvento.getLocal().split(",");
            double latitude = Double.parseDouble(latlong[0]);
            double longitude = Double.parseDouble(latlong[1]);

            ArrayList<Evento> list = Evento.getListaEventosLatLong(new LatLng(latitude,longitude));

            if (list.size() > 1) {
                LatLng location = new LatLng(latitude, longitude);
                marker.position(location);
                marker.title("Varios eventos");
                marker.snippet("Há varios eventos por aqui!");
                marker.alpha(0.8f);
                marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

                mMap.addMarker(marker);


            } else {
                Date data = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String data1 = dateFormat.format(data);
                String data2 = dateFormat.format(listaEvento.getDataEvento());
                if (data1.equals(data2)){
                    // quer diser que o evento é naquele dia
                    LatLng location = new LatLng(latitude, longitude);
                    marker.position(location);
                    marker.title(listaEvento.getNome());
                    marker.snippet(listaEvento.getDescricao());
                    marker.alpha(0.8f);
                    marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                    mMap.addMarker(marker);


                }
                if (!data1.equals(data2)){
                    // quer diser que o evento nao é naquele dia
                    LatLng location = new LatLng(latitude, longitude);
                    marker.position(location);
                    marker.title(listaEvento.getNome());
                    marker.snippet(listaEvento.getDescricao());
                    marker.alpha(0.8f);
                    marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

                    mMap.addMarker(marker);


                }



            }
        }
    }

    private LatLng getMinhaLocalizacao() {

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        LocationManager locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);

        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);


        if (!(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            String provider = locationManager.getBestProvider(criteria, false);
            Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            // Location location = locationManager.getLastKnownLocation(provider);

            LatLng local = null;
            if (location != null) {
                local = new LatLng(location.getLatitude(), location.getLongitude());
            } else {
                Toast.makeText(getActivity(), "Falha ao tentar acessar sua localização", Toast.LENGTH_SHORT);
            }
            return local;
        }
        //fim da tag
        return null;
    }


    private void criarRaio() {

        int raio = 15000;
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(getMinhaLocalizacao())
                .radius(raio)
                .strokeColor(Color.BLACK)
                .fillColor(Color.TRANSPARENT));
        // move a camera em um certo raio de distancia

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(getMinhaLocalizacao(), 10));
    }


    @Override
    public void onMapClick(LatLng latLng) {

    }
}
