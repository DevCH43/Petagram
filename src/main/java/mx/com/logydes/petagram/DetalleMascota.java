package mx.com.logydes.petagram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by devch on 14/05/16.
 */
public class DetalleMascota extends AppCompatActivity {

    TextView tvNombreMascota;
    TextView tvNumLikes;
    ImageView imgFotoMascota;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle params = getIntent().getExtras();

        String _tvNombreMascota = params.getString(getResources().getString(R.string.nombremascota));
        int _imgFotoMascota = params.getInt(getResources().getString(R.string.imgFotoMascota));
        String _tvNumLikes = params.getString(getResources().getString(R.string.numlikemascota));

        tvNombreMascota = (TextView) findViewById(R.id.tvNombreMascota);
        imgFotoMascota = (ImageView) findViewById(R.id.imgFotoMascota);
        tvNumLikes = (TextView) findViewById(R.id.tvNumLikes);

        tvNombreMascota.setText(_tvNombreMascota);
        imgFotoMascota.setImageResource(_imgFotoMascota);
        tvNumLikes.setText(_tvNumLikes);

    }

}
