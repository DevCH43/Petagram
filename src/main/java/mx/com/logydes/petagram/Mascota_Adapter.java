package mx.com.logydes.petagram;


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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by devch on 14/05/16.
 */
public class Mascota_Adapter extends RecyclerView.Adapter<Mascota_Adapter.Mascota_AdapterViewHolder> {


        private ArrayList<Mascotas_Master> MM;
        private Activity activity;

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

        // Asocia cada elemento de la lista al view
        @Override
        public void onBindViewHolder(Mascota_AdapterViewHolder cvh, int position) {

            final Mascotas_Master mm = MM.get(position);

            cvh.nombremascota.setText(mm.getNombremascota());
            cvh.fotomascota.setImageResource(mm.getFotomascota());
            String nlikes = String.valueOf(mm.getNumlikemascota());
            cvh.numlikemascota.setText(nlikes );

            cvh.fotomascota.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetalleMascota.class);
                    String nlikes = String.valueOf(mm.getNumlikemascota());
                    intent.putExtra(activity.getString(R.string.nombremascota) , mm.getNombremascota() );
                    intent.putExtra(activity.getString(R.string.imgFotoMascota), mm.getFotomascota() );
                    intent.putExtra(activity.getString(R.string.numlikemascota), nlikes );
                    activity.startActivity(intent);

                }
            });

            cvh.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity,"Diste click a "+mm.getNombremascota(),Toast.LENGTH_SHORT).show();
                }
            });

        }




    public int getItemCount() {
        return MM.size();
    }

    public static class Mascota_AdapterViewHolder extends RecyclerView.ViewHolder{

        // private int idmascota;
        ImageView fotomascota;
        TextView nombremascota;
        TextView numlikemascota;
        Button btnLike;

        public Mascota_AdapterViewHolder(View itemView) {
            super(itemView);

            fotomascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            nombremascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            numlikemascota = (TextView) itemView.findViewById(R.id.tvNumLikes);
            btnLike = (Button) itemView.findViewById(R.id.btnLike);



        }


    }

}
