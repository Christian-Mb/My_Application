package com.example.testrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements DetecteurDeClicSurRecycler {
    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CoordinatorLayout mcoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);

        ((GridLayoutManager)mLayoutManager) .setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {

                    @Override
                    public int getSpanSize(int arg0) {
                        return (arg0 % 3) == 0 ? 2 : 1;
                    }
                });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);

        //RecyclerView.ItemDecoration itemDecoration =
              //  new DividerItemDecoration(this, R.drawable.divider);
        //mRecyclerView.addItemDecoration(itemDecoration);

    }

    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index < 20; index++) {
            Donnee obj = new Donnee("Texte principal " + index,"Texte auxiliaire " + index);
            results.add(index, obj);
        }
        return results;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler((DetecteurDeClicSurRecycler) this);
    }






    @Override
    public void clicSurRecyclerItem(int position, View v) {
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();


    }
}
