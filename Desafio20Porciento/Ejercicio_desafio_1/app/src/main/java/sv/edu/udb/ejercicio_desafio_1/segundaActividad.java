package sv.edu.udb.ejercicio_desafio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class segundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);


        Bundle bundle = getIntent().getExtras();
        String strAnos = bundle.getString("txtAnos");
        String strSueldo = bundle.getString("txtSueldo");

        double dAnos = Double.parseDouble(strAnos);
        double dSueldo = Double.parseDouble(strSueldo);

        // a) Si el sueldo es inferior a 500 y su antigüedad es igual o superior a 10 años, otorgarle un aumento del 20 %, mostrar el sueldo a pagar.
        if(dSueldo < 500 && dAnos >= 10){
            dSueldo = dSueldo * 1.2;
        }
        // b) Si el sueldo es inferior a 500 pero su antigüedad es menor a 10 años, otorgarle un aumento de 5 %.
        else if(dSueldo < 500 && dAnos < 10){
            dSueldo = dSueldo * 1.05;
        }
        // c) Si el sueldo es mayor o igual a 500 mostrar el sueldo en pantalla sin cambios.
        strSueldo = Double.toString(dSueldo);

        TextView txtSueldoFinal = (TextView)findViewById(R.id.txtSueldoFinal);
        txtSueldoFinal.setText("El sueldo final sera de " + strSueldo);
    }

    public void finalizar(View v) {
        finish();
    }
}