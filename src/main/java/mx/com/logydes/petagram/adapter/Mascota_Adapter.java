package mx.com.logydes.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.logydes.petagram.DetalleMascota;
import mx.com.logydes.petagram.DetalleMascota2;
import mx.com.logydes.petagram.db.ConstructorMascotas;
import mx.com.logydes.petagram.pojo.Mascota_Detalle;
import mx.com.logydes.petagram.pojo.Mascotas_Master;
import mx.com.logydes.petagram.R;

/**
 * Created by devch on 26/05/16.
 */
public class Mascota_Adapter extends RecyclerView.Adapter<Mascota_Adapter.Mascota_AdapterViewHolder> {

    private ArrayList<Mascotas_Master> MM;
    private Activity activity;
    ConstructorMascotas cm;

    public Mascota_Adapter(ArrayList<Mascotas_Master> mm, Activity activity){
        this.MM = mm;
        this.activity = activity;
    }

    // Infla el Layout y lo pasa a cada elemento para que obtenga los view
    @Override
    public Mascota_AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new Mascota_AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Mascota_AdapterViewHolder cvh, int position) {

        final Mascotas_Master mm = MM.get(position);
        cvh.fotomascota.setImageResource(mm.getFotomascota());
        cvh.nombreMascota.setText(mm.getNombremascota() );
        // String nlikes = String.valueOf(mm.getNumlikemascota());
        cvh.numlikemascota.setText(getLikes( mm ) );
        cvh.IdMascota = mm.getIdmascota();

        cvh.fotomascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra(activity.getString(R.string.imgFotoMascota), mm.getFotomascota() );
                intent.putExtra(activity.getString(R.string.nombremascota), mm.getNombremascota() );
                intent.putExtra(activity.getString(R.string.numlikemascota), getLikes( mm ) );
                intent.putExtra(activity.getString(R.string.IdMascota), cvh.IdMascota );
                activity.startActivity(intent);

            }
        });

        cvh.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(activity, "Like", Toast.LENGTH_SHORT).show();
                cm = new ConstructorMascotas(activity);
                cm.setLike(mm);
                cvh.numlikemascota.setText(getLikes(mm));

            }
        });





    }

    public String getLikes(Mascotas_Master mm){
        cm = new ConstructorMascotas(activity);
        String likes = String.valueOf( cm.getLikes(mm) );
        return String.valueOf( cm.getLikes(mm) );
    }

    public int getItemCount() {
        return MM.size();
    }

    public static class Mascota_AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView fotomascota;
        TextView numlikemascota;
        TextView nombreMascota;
        Button btnLike;
        int IdMascota;

        public Mascota_AdapterViewHolder(View itemView) {
            super(itemView);

            IdMascota = 0;
            fotomascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            nombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            numlikemascota = (TextView) itemView.findViewById(R.id.tvNumLikes);
            btnLike = (Button) itemView.findViewById(R.id.btnLike);

        }


    }

}
