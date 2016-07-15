package toxoid.com.second;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Offer_Details extends AppCompatActivity implements OnMapReadyCallback {
    ScrollView scrollView;
    ImageView FullImage;
    String mob = "7381885658";
    TextView details;
    FloatingActionButton fab;
    int value;
    ImageView HalfImage;
    static Integer[] drawableArray = {R.drawable.zz,R.drawable.yy,R.drawable.xx,R.drawable.ww,R.drawable.vv,
            R.drawable.uu,R.drawable.tt,R.drawable.pp,R.drawable.qq,R.drawable.rr};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer__details);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           value = extras.getInt("key");
            //The key argument here must match that used in the other activity
        }
        FullImage = (ImageView) findViewById(R.id.imageView3);
        HalfImage = (ImageView) findViewById(R.id.imageView2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        FullImage.setImageResource(drawableArray[value]);

        HalfImage.setImageResource(drawableArray[value]);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(Offer_Details.this);

     //   SupportMapFragment mapFragment = (SupportMapFragment) this.getSupportFragmentManager()
      //          .findFragmentById(R.id.map);
       // mapFragment.getMapAsync(this);

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        FullImage = (ImageView) findViewById(R.id.imageView3);
        HalfImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.INVISIBLE);
                FullImage.setVisibility(View.VISIBLE);
                fab.setVisibility(View.INVISIBLE);
            }
        });

        Button back=(Button)findViewById(R.id.button3);
        final Button Home = (Button) findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Offer_Details.this, Home.class);
                startActivity(intent);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Offer_Details.this, Home.class);
                startActivity(intent);
            }
        });





     /*   Geocoder geocoder;
        List<Address> addresses = (List<Address>) new Address(Locale.CANADA);
        geocoder = new Geocoder(this, Locale.getDefault());


        try {
            addresses = geocoder.getFromLocation(20.2790851, 85.8417821, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName();

        details=(TextView)findViewById(R.id.textView4);
        details.setText(address+city+state+country+postalCode+knownName);

        */

         fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mob));
                if (ActivityCompat.checkSelfPermission(Offer_Details.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (scrollView.getVisibility() == View.INVISIBLE) {
            scrollView.setVisibility(View.VISIBLE);
            FullImage.setVisibility(View.INVISIBLE);
            fab.setVisibility(View.VISIBLE);
        } else {
            Intent intent = new Intent(Offer_Details.this, Home.class);
            startActivity(intent);
        }
    }

    @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng BigBazar = new LatLng(20.2790851, 85.8417821);


            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

                return;
            }
        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BigBazar, 13));
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);


        googleMap.addMarker(new MarkerOptions()
                .title("BigBazar")
                .snippet("The most populous shopping mall.")
                .position(BigBazar));


    }
    }

