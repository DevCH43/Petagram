package mx.com.logydes.petagram;

import java.util.Date;

/**
 * Created by devch on 14/05/16.
 */
public class Mascota_Detalle {
    private int idmascotadetalle;
    private int idmascota;
    private int iduser;
    private Date fechalike;

    public Mascota_Detalle(int idmascota, int iduser) {
        this.idmascota = idmascota;
        this.iduser = iduser;
    }

    public int getIdmascotadetalle() {
        return idmascotadetalle;
    }

    public void setIdmascotadetalle(int idmascotadetalle) {
        this.idmascotadetalle = idmascotadetalle;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Date getFechalike() {
        return fechalike;
    }

    public void setFechalike(Date fechalike) {
        this.fechalike = fechalike;
    }
}
