package toxoid.com.second;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.felipecsl.asymmetricgridview.library.Utils;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;
import com.parse.Parse;
import com.parse.ParseBroadcastReceiver;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.PushService;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class ShopList extends AppCompatActivity {
    private static ShopList sInstance;
    PendingIntent pendingIntent;

    // CharSequence data;
    /**
     * @return ApplicationController singleton instance
     */
    public static synchronized ShopList getInstance() {
        return sInstance;
    }

    Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        //     AsymmetricGridView listView = (AsymmetricGridView) findViewById(R.id.listView);
/*
        // Choose your own preferred column width
        listView.setRequestedColumnWidth(Utils.dpToPx(this, 120));
        final List<AsymmetricItem> items = new ArrayList<>();

        // initialize your items array
        //
        ListAdapter adapter = new ListAdapter(this, listView, items);
        AsymmetricGridViewAdapter asymmetricAdapter =
                new AsymmetricGridViewAdapter<>(this, listView, adapter);
        listView.setAdapter(asymmetricAdapter);
        listView.setAllowReordering(true);
         */


        Parse.initialize(new Parse.Configuration.Builder(ShopList.this)
                .applicationId("MxozMywchyh6bSvdtNgaPhaiSHBlFqrlgAlDMyR2")
                .clientKey("1r6ACWWjdYiYG6eR3pLrtdVnqNcxkiSRGHsfTUDB")
                .server("https://parseapi.back4app.com/")
                .build()
        );
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(ShopList.this, "successfully subscribed to the broadcast channel", Toast.LENGTH_SHORT).show();
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }

        });

        // initialize the singleton
        sInstance = this;





    }
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(), "onReceive invoked!", Toast.LENGTH_LONG).show();
        }
    };
    @Override
    public void onPause() {
        super.onPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    public void onResume() {
        super.onResume();

        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, new IntentFilter(MyCustomReceiver.intentAction));
    }
}

