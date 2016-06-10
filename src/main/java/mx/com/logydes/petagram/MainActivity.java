package mx.com.logydes.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import mx.com.logydes.petagram.adapter.Mascota_Adapter;
import mx.com.logydes.petagram.fragment.PerfilFragment;
import mx.com.logydes.petagram.fragment.RecycleVIew_Fragment;
import mx.com.logydes.petagram.pojo.Mascotas_Master;
import mx.com.logydes.petagram.presentador.ReclyclerViewFragmentPresenter;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sifMiIndicatorRefresh;
    Adapter adaptador;
    ArrayList<Mascotas_Master> mm;
    FloatingActionButton fab;
    ImageView myFav;


    private RecyclerView listaMM;
    private ReclyclerViewFragmentPresenter RVP;

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

        agregarFragments();

        // listaMM = (RecyclerView) findViewById(R.id.rvContactos);
        // RVP = (ReclyclerViewFragmentPresenter) findViewById(R.id.rvContactos);

/*
        // Para Linear Layout
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMM.setLayoutManager(llm);


        // Para Grid Layout
        /*
        GridLayoutManager glm = new GridLayoutManager(this,2);
        listaMM.setLayoutManager(glm);
        */

        //initListContactos();
        //InitAdapter();

        sifMiIndicatorRefresh = (SwipeRefreshLayout) findViewById(R.id.sifMiIndicatorRefresh);
        sifMiIndicatorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sifMiIndicatorRefresh.setRefreshing(false);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Agregar un nuevo Item", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });

        myFav = (ImageView) findViewById(R.id.myFav);
        myFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Agregado a Favorito", Toast.LENGTH_SHORT).show();
            }
        });



        /*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        */


    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecycleVIew_Fragment());
        fragments.add(new PerfilFragment());
        return fragments;

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
