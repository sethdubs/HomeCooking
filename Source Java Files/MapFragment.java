package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {
    MapView mMapView;
    private GoogleMap mMap;
    private GoogleApiClient mClient;
    private static final String TAG = "MapFragment";
    Context context;
    User user;
    Button mCurrentLocButton;
    LatLng mCurrentLocation;
    Marker mMarker;

//    OnButtonClickedListener mListener;u
    OnInfoWindowClickedListener mListener;

    public interface OnInfoWindowClickedListener {
        public void onInfoWindowClick1();
    }
//    public interface OnButtonClickedListener {
//        public void onButtonClicked5(View v);
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnInfoWindowClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .build();

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate and return the layout
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        user = User.getUser();
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately
        context = getActivity().getApplicationContext();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMap = mMapView.getMap();
//        LatLng auburn = new LatLng(32.6099, -85.4808);
//        LatLng mont = new LatLng(32.3668, -86.3000);
//        LatLng kirk1 = new LatLng(33.751736, -84.322622);
//        LatLng kirk2 = new LatLng(33.754020, -84.314476);
//        LatLng kirk3 = new LatLng(33.745818, -84.319144);
//        MarkerOptions cook1 = new MarkerOptions().position(kirk1).title("Cook 1").snippet("Hamburger - $5");
//        MarkerOptions cook2 = new MarkerOptions().position(kirk2).title("Cook 2").snippet("Sushi - $8");
//        MarkerOptions cook3 = new MarkerOptions().position(kirk3).title("Cook 3").snippet("Pizza - $6");
//        mMap.addMarker(cook1);
//        mMap.addMarker(cook2);
//        mMap.addMarker(cook3);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String title = marker.getTitle();
                switch(title) {
                    case "Cook 1":
                        mListener.onInfoWindowClick1();
                        user.setCurrentMarker(1);
                        break;
                    case "Cook 2":
                        mListener.onInfoWindowClick1();
                        user.setCurrentMarker(2);
                        break;
                    case "Cook 3":
                        mListener.onInfoWindowClick1();
                        user.setCurrentMarker(3);
                        break;
                }

            }
        });


        mCurrentLocButton = (Button)v.findViewById(R.id.current_location_button);
        mCurrentLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findLoc();

            }
        });

        return v;
    }


    public void findLoc() {
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setNumUpdates(1);
        request.setInterval(0);
        user = User.getUser();

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi
                .requestLocationUpdates(mClient, request, new com.google.android.gms.location.LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Log.i(TAG, "Got a fix: " + location);
                        user.setLng(location.getLongitude());
                        user.setLat(location.getLatitude());
                        user.createLatLng();
                        user.createMarkerOptions();
                        mMarker = user.makeMarker(mMap);
                        //hca.addUser(user);
                        mCurrentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.addMarker(user.getmMarkerOptions().title("Current Location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(mCurrentLocation));
                        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                        LatLng kirk1 = new LatLng(33.751736, -84.322622);
                        LatLng kirk2 = new LatLng(33.754020, -84.314476);
                        LatLng kirk3 = new LatLng(33.745818, -84.319144);
                        MarkerOptions cook1 = new MarkerOptions().position(kirk1).title("Cook 1").snippet("Hamburger - $5");
                        MarkerOptions cook2 = new MarkerOptions().position(kirk2).title("Cook 2").snippet("Sushi - $8");
                        MarkerOptions cook3 = new MarkerOptions().position(kirk3).title("Cook 3").snippet("Pizza - $6");
                        mMap.addMarker(cook1);
                        mMap.addMarker(cook2);
                        mMap.addMarker(cook3);
                        user.setCookId(1, 0);
                        user.setCookId(2, 1);
                        user.setCookId(3, 2);
                        user.setFoodItem("HamBurger", 0);
                        user.setPrice(5, 0);
                        user.setFoodItem("Sushi", 1);
                        user.setPrice(8, 1);
                        user.setFoodItem("Pizza", 2);
                        user.setPrice(6, 2);


                    }
                });



    }







    @Override
    public void onStart() {
        super.onStart();

        mClient.connect();

    }





    @Override
    public void onStop() {
        super.onStop();

        mClient.disconnect();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        mMapView.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        mMapView.onPause();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mMapView.onDestroy();
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mMapView.onLowMemory();
//    }


}
