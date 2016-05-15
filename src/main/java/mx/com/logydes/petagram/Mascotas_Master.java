package mx.com.logydes.petagram;

/**
 * Created by devch on 14/05/16.
 */
public class Mascotas_Master {
    private int idmascota;
    private String nombremascota;
    private int fotomascota;
    private int numlikemascota;

    public Mascotas_Master(int idmascota, String nombremascota, int fotomascota) {
        this.idmascota = idmascota;
        this.nombremascota = nombremascota;
        this.fotomascota = fotomascota;
    }

    public Mascotas_Master(int idmascota, String nombremascota, int fotomascota, int numlikemascota) {
        this.idmascota = idmascota;
        this.nombremascota = nombremascota;
        this.fotomascota = fotomascota;
        this.numlikemascota = numlikemascota;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    public int getFotomascota() {
        return fotomascota;
    }

    public void setFotomascota(int fotomascota) {
        this.fotomascota = fotomascota;
    }

    public int getNumlikemascota() {
        return numlikemascota;
    }

    public void setNumlikemascota(int numlikemascota) {
        this.numlikemascota = numlikemascota;
    }


}
