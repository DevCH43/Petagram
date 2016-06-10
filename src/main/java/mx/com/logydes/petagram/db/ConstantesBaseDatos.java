package mx.com.logydes.petagram.db;

/**
 * Created by devch on 9/06/16.
 */
public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "Mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Mascota_Master";
    public static final String TABLE_ID = "idmascota";
    public static final String TABLE_NOMBRE_MASCOTA = "nombremascota";
    public static final String TABLE_FOTO_MASCOTA = "fotomascota";
    public static final String TABLE_NUM_LIKES_MASCOTA = "numlikemascota";

    public static final String TABLE_MD_NAME = "Mascota_Detalle";
    public static final String TABLE_MD_IDMASCOTA = "idmascota";
    public static final String TABLE_MD_ID = "idmascotadetalle";
    public static final String TABLE_MD_USER = "iduser";
    public static final String TABLE_MD_FECHA = "fechalike";
    public static final int TABLE_MD_LIKE = 1;

}
