package com.example.foodrecommended_asd;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    static double latit; // Latitude
    static double longit; // Longitude
    static String zip; // Zipcode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // This gets the latitude and longitude from the user
        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }else{
            try {
                LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();
                latit = latitude; // Add to our static variables for moving the marker
                longit = longitude;
                // This will turn the latitude and longitude into a zip code to put into the database.
                Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
                List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                Address address = null;
                String addr = ""; // Address
                String zipcode = "";
                String city = "";
                String state = "";
                if (addresses != null && addresses.size() > 0) {

                    addr = addresses.get(0).getAddressLine(0) + "," + addresses.get(0).getSubAdminArea();
                    city = addresses.get(0).getLocality();
                    state = addresses.get(0).getAdminArea(); // Get's the closest area based off network

                    for (int i = 0; i < addresses.size(); i++) {
                        address = addresses.get(i);
                        if (address.getPostalCode() != null) {
                            zipcode = address.getPostalCode();
                            zip = zipcode;
                            break;
                        }

                    }
                }
            }
            catch(Exception ex){
                ex.printStackTrace(); // Catches exception for addresses
            }
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near the user's location.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in the User's Location and move the camera
        LatLng userLocation = new LatLng(latit, longit);
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Marker in User's Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
    }

    // When a MapActivity object is created, you are able to retrieve the Zip.
    String getZip(){
        return zip;
    }
}
