package mx.com.logydes.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.com.logydes.petagram.Mascotas_Master;
import mx.com.logydes.petagram.R;
import mx.com.logydes.petagram.adapter.Mascota_Adapter;

/**
 * Created by devch on 21/05/16.
 */
public class RecycleVIew_Fragment extends Fragment{

    SwipeRefreshLayout sifMiIndicatorRefresh;
    Adapter adaptador;

    ArrayList<Mascotas_Master> mm;
    FloatingActionButton fab;
    ImageView myFav;

    private RecyclerView listaMM;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);


        listaMM = (RecyclerView) v.findViewById(R.id.rvContactos);

        // Para Linear Layout
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMM.setLayoutManager(llm);

        // Para Grid Layout
        /*
        GridLayoutManager glm = new GridLayoutManager(this,2);
        listaMM.setLayoutManager(glm);
        */

        initListContactos();
        InitAdapter();

        sifMiIndicatorRefresh = (SwipeRefreshLayout) v.findViewById(R.id.sifMiIndicatorRefresh);
        sifMiIndicatorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sifMiIndicatorRefresh.setRefreshing(false);
            }
        });

        return v;
        // return super.onCreateView(inflater, container, savedInstanceState);
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
        Mascota_Adapter mad = new Mascota_Adapter(mm,getActivity());
        listaMM.setAdapter(mad);
    }

}
