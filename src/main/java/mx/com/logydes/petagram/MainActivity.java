package mx.com.logydes.petagram;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sifMiIndicatorRefresh;
    Adapter adaptador;
    ArrayList<Mascotas_Master> mm;

    private RecyclerView listaMM;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaMM = (RecyclerView) findViewById(R.id.rvContactos);

        // Para Linear Layout
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMM.setLayoutManager(llm);

        // Para Grid Layout
        /*
        GridLayoutManager glm = new GridLayoutManager(this,2);
        listaMM.setLayoutManager(glm);
        */

        initListContactos();
        InitAdapter();

        sifMiIndicatorRefresh = (SwipeRefreshLayout) findViewById(R.id.sifMiIndicatorRefresh);
        sifMiIndicatorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sifMiIndicatorRefresh.setRefreshing(false);
            }
        });


    }

    public void InitAdapter(){
        Mascota_Adapter mad = new Mascota_Adapter(mm,this);
        listaMM.setAdapter(mad);
    }

    public void initListContactos(){

        mm = new ArrayList<Mascotas_Master>();
        mm.add( new Mascotas_Master( 0,"Popis",R.drawable.perro ,2) );
        mm.add( new Mascotas_Master( 1,"Lupis",R.drawable.gato,5) );
        mm.add( new Mascotas_Master( 2,"Mopis",R.drawable.oso,17) );
        mm.add( new Mascotas_Master( 3,"Juanis",R.drawable.erizo,0 ) );
        mm.add( new Mascotas_Master( 4,"Chabelis",R.drawable.ave,4 ) );
        mm.add( new Mascotas_Master( 5,"Luis",R.drawable.mono,11) );
        mm.add( new Mascotas_Master( 6,"Kukis",R.drawable.pupi,9) );
        mm.add( new Mascotas_Master( 7,"Rikis",R.drawable.conejo,8 ) );


    }



}
