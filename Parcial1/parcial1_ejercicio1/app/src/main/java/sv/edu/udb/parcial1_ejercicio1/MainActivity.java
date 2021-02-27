package sv.edu.udb.parcial1_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etA,etB,etC;
    Button btnCalcular;
    double dRaiz1, dRaiz2, dA,dB,dC, dDeterminante;
    String strA,strB,strC;
    Toast tNotificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etA =(EditText) findViewById(R.id.etA);
                etB =(EditText) findViewById(R.id.etB);
                etC =(EditText) findViewById(R.id.etC);


                strA = etA.getText().toString();
                strB = etB.getText().toString();
                strC = etC.getText().toString();
                dA = Double.parseDouble(strA);
                dB = Double.parseDouble(strB);
                dC = Double.parseDouble(strC);

                dDeterminante = dB * dB - 4 * dA * dC;

                if (dDeterminante > 0) {

                    dRaiz1 = (-dB + Math.sqrt(dDeterminante)) / (2 * dA);
                    dRaiz2 = (-dB - Math.sqrt(dDeterminante)) / (2 * dA);

                    Intent segundaActividadIntent = new Intent(getApplicationContext(), segundaActividad.class);
                    segundaActividadIntent.putExtra("txtRaiz1", String.valueOf(dRaiz1));
                    segundaActividadIntent.putExtra("txtRaiz2", String.valueOf(dRaiz2));
                    startActivity(segundaActividadIntent);

                    //System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
                }
                else if (dDeterminante == 0) {
                    dRaiz1 = dRaiz2 = -dB / (2 * dA);

                    //System.out.format("root1 = root2 = %.2f;", root1);
                }
                else {
                    tNotificaciones =  Toast.makeText(getApplicationContext(),"Las variables ingresadas crean raizes negativas. Por favor ingresar otras variables.",Toast.LENGTH_LONG);
                    tNotificaciones.show();
                }
            }
        });
    }
}