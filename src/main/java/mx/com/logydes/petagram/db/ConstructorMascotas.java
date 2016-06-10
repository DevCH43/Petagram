package mx.com.logydes.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.com.logydes.petagram.R;
import mx.com.logydes.petagram.pojo.Mascotas_Master;

/**
 * Created by devch on 2/06/16.
 */
public class ConstructorMascotas {
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas_Master> obtenerDatos(){

        /*
        ArrayList<Mascotas_Master> mm = new ArrayList<Mascotas_Master>();
        mm.add( new Mascotas_Master( 0,"Popis",R.drawable.perro ,2) );
        mm.add( new Mascotas_Master( 1,"Lupis",R.drawable.gato,5) );
        mm.add( new Mascotas_Master( 2,"Mopis",R.drawable.oso,17) );
        mm.add( new Mascotas_Master( 3,"Juanis",R.drawable.erizo,0 ) );
        mm.add( new Mascotas_Master( 4,"Chabelis",R.drawable.ave,4 ) );
        mm.add( new Mascotas_Master( 5,"Luis",R.drawable.mono,11) );
        mm.add( new Mascotas_Master( 6,"Kukis", R.drawable.pupi,9) );
        mm.add( new Mascotas_Master( 7,"Rikis",R.drawable.conejo,8 ) );
        */

        BaseDatos db = new BaseDatos(context);
        // insertarMarcotas(db);
        return db.obternerTodasLasMascotas();
    }

    public void insertarMarcotas(BaseDatos db){
        ContentValues cv  = new ContentValues();
        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Popis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.perro);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Lupis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.gato);
        // cv.put(ConstantesBaseDatos.TABLE_NUM_LIKES_MASCOTA,5);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Mopis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.oso);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Juanis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.erizo);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Chabelis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.ave);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Luis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.mono);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Kukis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.pupi);
        db.insertarMarcotas(cv);

        cv.put(ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA,"Rikis");
        cv.put(ConstantesBaseDatos.TABLE_FOTO_MASCOTA,R.drawable.conejo);
        db.insertarMarcotas(cv);


    }

    public void setLike(Mascotas_Master mm){
        BaseDatos db = new BaseDatos(context);
        ContentValues cv  = new ContentValues();
        cv.put(ConstantesBaseDatos.TABLE_MD_IDMASCOTA, mm.getIdmascota());
        cv.put(ConstantesBaseDatos.TABLE_MD_USER, ConstantesBaseDatos.TABLE_MD_LIKE);

        db.insertarLikes(cv);

    }

    public int getLikes(Mascotas_Master mm){
        int likes = 0;
        BaseDatos db = new BaseDatos(context);
        likes = db.getLikes(mm);
        return likes;
    }

    public int getLikesByID(int ID){
        int likes = 0;
        BaseDatos db = new BaseDatos(context);
        likes = db.getLikesByID(ID);
        return likes;
    }

}
