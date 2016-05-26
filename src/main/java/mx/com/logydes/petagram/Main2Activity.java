package mx.com.logydes.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.logydes.petagram.adapter.PageAdapter;
import mx.com.logydes.petagram.fragment.PerfilFragment;
import mx.com.logydes.petagram.fragment.RecycleVIew_Fragment;

public class Main2Activity extends AppCompatActivity {

    SwipeRefreshLayout sifMiIndicatorRefresh;

    //Adapter adaptador;
    PageAdapter pageAdapter;
    ArrayList<Fragment> fragments;
    ArrayList<Mascotas_Master> mm;
    Toolbar toolbar;
    TabLayout tl;
    ViewPager vp;
    FloatingActionButton fab;
    ImageView myFav;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        tl = (TabLayout) findViewById(R.id.tabLayout);
        vp = (ViewPager) findViewById(R.id.myViewPager);
        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }




        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getMenuOpt(v);
                Toast.makeText(getBaseContext(), "Hola @AnnCode", Toast.LENGTH_SHORT).show();
            }
        });



/*
        myFav = (ImageView) findViewById(R.id.myFav);
        myFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Agregado a Favorito", Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(myFav);
*/

    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecycleVIew_Fragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUpViewPager(){
        vp.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tl.setupWithViewPager(vp);

        tl.getTabAt(0).setIcon(R.drawable.ic_home_white);
        //tl.getTabAt(0).setText("Mascotas");

        tl.getTabAt(1).setIcon(R.drawable.ic_dog_white);
        //tl.getTabAt(1).setText("Otros");

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return getMenu(item);
    }


    public void getMenuOpt(View view){
        PopupMenu pm  = new PopupMenu(this,view);
        pm.getMenuInflater().inflate(R.menu.menu_options,pm.getMenu());
        pm.show();
        pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return getMenu(item);
            }
        });
    }

    public boolean getMenu(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnView:
                Toast.makeText(getBaseContext(),"Uno",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnViewDetail:
                Toast.makeText(getBaseContext(),"Dos",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRefresh:
                Toast.makeText(getBaseContext(),"Refresh",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuContact:
                //Toast.makeText(getBaseContext(),"Uno",Toast.LENGTH_SHORT).show();
                intent = new Intent(Main2Activity.this,ContactActivity.class);
                startActivity(intent);
                break;
            case R.id.mnuAbout:
                intent = new Intent(Main2Activity.this,AboutActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }



}
