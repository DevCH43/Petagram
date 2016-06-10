package mx.com.logydes.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.com.logydes.petagram.db.ConstructorMascotas;
import mx.com.logydes.petagram.fragment.iRecyclerViewFragmentView;
import mx.com.logydes.petagram.pojo.Mascotas_Master;

/**
 * Created by devch on 2/06/16.
 */

public class ReclyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {
    private iRecyclerViewFragmentView iRVF;
    private Context context;
    private ConstructorMascotas cm;
    private ArrayList<Mascotas_Master> mm;

    public ReclyclerViewFragmentPresenter(iRecyclerViewFragmentView iRVF, Context context) {
        this.iRVF = iRVF;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        ConstructorMascotas cm = new ConstructorMascotas(this.context);
        this.mm = cm.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRVF.InitAdapter(iRVF.createAdapter(this.mm));
        // iRVF.generarLinearLayoutVertical();
    }
}
