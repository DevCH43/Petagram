package mx.com.logydes.petagram.fragment;

import java.util.ArrayList;

import mx.com.logydes.petagram.adapter.Mascota_Adapter;
import mx.com.logydes.petagram.pojo.Mascotas_Master;

/**
 * Created by devch on 2/06/16.
 */
public interface iRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public Mascota_Adapter createAdapter(ArrayList<Mascotas_Master> mm);

    public void InitAdapter(Mascota_Adapter mad);

}
