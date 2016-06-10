package mx.com.logydes.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.logydes.petagram.adapter.Mascota_Simple_for_Grid_Adapter;
import mx.com.logydes.petagram.pojo.Mascotas_Master;

public class DetalleMascota2 extends AppCompatActivity {

    SwipeRefreshLayout sifMiIndicatorRefresh;
    TextView idFotoMascota;
    TextView tvNombreMascota;
    ImageView imgFotoMascota;
    FloatingActionButton fab;
    ImageView myFav;
    Intent intent;
    ArrayList<Mascotas_Master> mm;
    RecyclerView listaMM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota2);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle params = getIntent().getExtras();

        String _tvNombreMascota = params.getString(getResources().getString(R.string.nombremascota));
        int _imgFotoMascota = params.getInt(getResources().getString(R.string.imgFotoMascota));
        String _IdMascota = params.getString(getResources().getString(R.string.IdMascota));

        tvNombreMascota = (TextView) findViewById(R.id.tvNombreMascota);
        imgFotoMascota = (ImageView) findViewById(R.id.imgFotoMascota);

        tvNombreMascota.setText(_tvNombreMascota);
        imgFotoMascota.setImageResource(_imgFotoMascota);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getMenuOpt(v);
                Toast.makeText(getBaseContext(), "Hola @AnnCode", Toast.LENGTH_SHORT).show();
            }
        });

        listaMM = (RecyclerView) findViewById(R.id.rvContactos);

        // Para Linear Layout
        /*
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMM.setLayoutManager(llm);
        */

        // Para Grid Layout

        GridLayoutManager glm = new GridLayoutManager(this,2);
        listaMM.setLayoutManager(glm);


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

    public void InitAdapter(){
        Mascota_Simple_for_Grid_Adapter mad = new Mascota_Simple_for_Grid_Adapter(mm,this);
        listaMM.setAdapter(mad);
    }

}
