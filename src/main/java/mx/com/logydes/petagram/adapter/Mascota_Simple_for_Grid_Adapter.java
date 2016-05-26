package mx.com.logydes.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.logydes.petagram.DetalleMascota2;
import mx.com.logydes.petagram.Mascotas_Master;
import mx.com.logydes.petagram.R;
import mx.com.logydes.petagram.pojo.RoundImage;

/**
 * Created by devch on 26/05/16.
 */
public class Mascota_Simple_for_Grid_Adapter extends RecyclerView.Adapter<Mascota_Simple_for_Grid_Adapter.Mascota_AdapterViewHolder> {

        private ArrayList<Mascotas_Master> MM;
        private Activity activity;

        public Mascota_Simple_for_Grid_Adapter(ArrayList<Mascotas_Master> mm, Activity activity){
            this.MM = mm;
            this.activity = activity;
        }

        // Infla el Layout y lo pasa a cada elemento para que obtenga los view
        @Override
        public Mascota_AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas2, parent, false);
            return new Mascota_AdapterViewHolder(v);
        }

        @Override
        public void onBindViewHolder(Mascota_AdapterViewHolder cvh, int position) {

            final Mascotas_Master mm = MM.get(position);

            cvh.fotomascota.setImageResource(mm.getFotomascota());
            String nlikes = String.valueOf(mm.getNumlikemascota());
            cvh.numlikemascota.setText(nlikes );

            cvh.fotomascota.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetalleMascota2.class);
                    String nlikes = String.valueOf(mm.getNumlikemascota());
                    intent.putExtra(activity.getString(R.string.imgFotoMascota), mm.getFotomascota() );
                    intent.putExtra(activity.getString(R.string.numlikemascota), nlikes );
                    activity.startActivity(intent);

                }
            });

        }

        public int getItemCount() {
            return MM.size();
        }

        public static class Mascota_AdapterViewHolder extends RecyclerView.ViewHolder{

            ImageView fotomascota;
            TextView numlikemascota;

            public Mascota_AdapterViewHolder(View itemView) {
                super(itemView);

                fotomascota = (ImageView) itemView.findViewById(R.id.imgFotoMascotaMini);
                numlikemascota = (TextView) itemView.findViewById(R.id.tvNumLikes);

            }


        }

    }
