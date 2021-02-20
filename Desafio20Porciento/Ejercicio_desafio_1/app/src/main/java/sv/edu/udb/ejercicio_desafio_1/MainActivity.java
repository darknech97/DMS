package sv.edu.udb.ejercicio_desafio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtAnos, txtSueldo;
    Button btnCalcular;
    Toast tMensajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txtAnos = (EditText) findViewById(R.id.txtAnos);
                txtSueldo = (EditText) findViewById(R.id.txtSueldo);


                String strAnos = txtAnos.getText().toString();
                String strSueldo = txtSueldo.getText().toString();
                double dAnos = Double.parseDouble(strAnos);
                double dSueldo = Double.parseDouble(strSueldo);

                if(dAnos < 0 || dSueldo < 0){
                    Toast notificacion= Toast.makeText(getApplicationContext(),"Por favor ingresar solamente numeros mayores a 0.",Toast.LENGTH_LONG);
                    notificacion.show();
                }
                else if(dAnos == 0 || dSueldo == 0){
                    Toast notificacion= Toast.makeText(getApplicationContext(),"Por favor ingresar solamente numeros mayores a 0.",Toast.LENGTH_LONG);
                    notificacion.show();
                }
                else if(dSueldo < 100){
                    Toast notificacion= Toast.makeText(getApplicationContext(),"Por favor ingresar un salario mayor a 100.",Toast.LENGTH_LONG);
                    notificacion.show();
                }
                else{
                    Intent segundaActividadIntent = new Intent(getApplicationContext(), segundaActividad.class);
                    segundaActividadIntent.putExtra("txtAnos", txtAnos.getText().toString());
                    segundaActividadIntent.putExtra("txtSueldo", txtSueldo.getText().toString());
                    startActivity(segundaActividadIntent);
                }

            }
        });

        //salario < 100 todos < 0

    }
}