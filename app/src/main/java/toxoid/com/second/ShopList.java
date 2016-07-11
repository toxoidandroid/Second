package toxoid.com.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.felipecsl.asymmetricgridview.library.Utils;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopList extends AppCompatActivity {



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

    }
}
