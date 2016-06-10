package mx.com.logydes.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.com.logydes.petagram.pojo.Mascotas_Master;

/**
 * Created by devch on 9/06/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryString = "CREATE TABLE "+ConstantesBaseDatos.TABLE_NAME+"("+
                ConstantesBaseDatos.TABLE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_NOMBRE_MASCOTA+" TEXT, "+
                ConstantesBaseDatos.TABLE_FOTO_MASCOTA+" INTEGER, "+
                ConstantesBaseDatos.TABLE_NUM_LIKES_MASCOTA+" INTEGER "+
                " )";

        db.execSQL(queryString);

                queryString = "CREATE TABLE "+ConstantesBaseDatos.TABLE_MD_NAME+"("+
                ConstantesBaseDatos.TABLE_MD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MD_IDMASCOTA+" INTEGER, "+
                ConstantesBaseDatos.TABLE_MD_USER+" INTEGER, "+
                ConstantesBaseDatos.TABLE_MD_FECHA+" DATE, "+
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MD_IDMASCOTA+") REFERENCES "+ConstantesBaseDatos.TABLE_NAME+"("+ConstantesBaseDatos.TABLE_ID+") "+
                " );";

        db.execSQL(queryString);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_MD_NAME);

        // db.execSQL("DROP TABLE "+ConstantesBaseDatos.TABLE_NAME);
        // db.execSQL("DROP TABLE "+ConstantesBaseDatos.TABLE_MD_NAME);

        onCreate(db);
    }

    public ArrayList<Mascotas_Master> obternerTodasLasMascotas(){
        ArrayList<Mascotas_Master> mm = new ArrayList<>();
        String queryString = "Select * from "+ConstantesBaseDatos.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor reg = db.rawQuery(queryString, null);
        while (reg.moveToNext()){
            Mascotas_Master MM = new Mascotas_Master();
            MM.setIdmascota(reg.getInt(0));
            MM.setNombremascota(reg.getString(1));
            MM.setFotomascota(reg.getInt(2));
            MM.setNumlikemascota(reg.getInt(3));
            mm.add(MM);
        }

        db.close();

        return mm;
    }

    public void insertarMarcotas(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_NAME,null,cv);
        db.close();

    }

    public void insertarLikes(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MD_NAME,null,cv);
        db.close();
    }

    public int getLikes(Mascotas_Master mm){
        int likes = 0;
        String queryString = "Select count("+ConstantesBaseDatos.TABLE_ID+") from "+ConstantesBaseDatos.TABLE_MD_NAME+ " WHERE "+ConstantesBaseDatos.TABLE_ID+" = "+mm.getIdmascota();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor reg = db.rawQuery(queryString, null);

        if ( reg.moveToNext() ){
            likes = reg.getInt(0);
        }

        return likes;
    }

    public int getLikesByID(int ID){

        int likes = 0;
        String queryString = "Select count("+ConstantesBaseDatos.TABLE_ID+") from "+ConstantesBaseDatos.TABLE_MD_NAME+ " WHERE "+ConstantesBaseDatos.TABLE_ID+" = "+ID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor reg = db.rawQuery(queryString, null);

        if ( reg.moveToNext() ){
            likes = reg.getInt(0);
        }

        return likes;

    }

}
