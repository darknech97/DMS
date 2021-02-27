package sv.edu.udb.parcial1_ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular;
    EditText etNombre1,etNombre2,etNombre3,etApellido1,etApellido2,etApellido3,etHoras1,etHoras2,etHoras3;
    Spinner spCargo1,spCargo2,spCargo3;
    Toast tNotificaciones;
    double dHoras1,dHoras2,dHoras3,dSalario1, dSalario2, dSalario3;
    double dIsss1,dIsss2,dIsss3,dAfp1,dAfp2,dAfp3,dRenta1,dRenta2,dRenta3,dLiquido1,dLiquido2,dLiquido3;
    String[] strsEmpleado1,strsEmpleado2,strsEmpleado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the spinner from the xml.
        spCargo1 = (Spinner)findViewById(R.id.spCargo1);
        spCargo2 = (Spinner)findViewById(R.id.spCargo2);
        spCargo3 = (Spinner)findViewById(R.id.spCargo3);
        //create a list of items for the spinner.
        String[] items = new String[]{"Secretaria", "Asistente", "Gerente"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spCargo1.setAdapter(adapter);
        spCargo2.setAdapter(adapter);
        spCargo3.setAdapter(adapter);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNombre1 = (EditText)findViewById(R.id.etNombre1);
                etNombre2 = (EditText)findViewById(R.id.etNombre2);
                etNombre3 = (EditText)findViewById(R.id.etNombre3);
                etApellido1 = (EditText)findViewById(R.id.etApellido1);
                etApellido2 = (EditText)findViewById(R.id.etApellido2);
                etApellido3 = (EditText)findViewById(R.id.etApellido3);
                etHoras1 = (EditText)findViewById(R.id.etHoras1);
                etHoras2 = (EditText)findViewById(R.id.etHoras2);
                etHoras3 = (EditText)findViewById(R.id.etHoras3);




                if(validarHoras(etHoras1,etHoras2,etHoras3)){
                    tNotificaciones =  Toast.makeText(getApplicationContext(),"Las horas trabajadas tienen que ser mayores a 0. Por favor ingresar un numero mayor a 0.",Toast.LENGTH_LONG);
                    tNotificaciones.show();
                }
                else if(validarNombres(etNombre1, etNombre2, etNombre3)){
                    tNotificaciones =  Toast.makeText(getApplicationContext(),"Por favor ingresar los nombres de todos los trabajadores.",Toast.LENGTH_LONG);
                    tNotificaciones.show();
                }
                else if(validarApellidos(etApellido1, etApellido2, etApellido3)){
                    tNotificaciones =  Toast.makeText(getApplicationContext(),"Por favor ingresar los apellidos de todos los trabajadores.",Toast.LENGTH_LONG);
                    tNotificaciones.show();
                }
                else{
                    dHoras1 = Double.parseDouble(etHoras1.getText().toString());
                    dHoras2 = Double.parseDouble(etHoras2.getText().toString());
                    dHoras3 = Double.parseDouble(etHoras3.getText().toString());

                    if(dHoras1 <= 160){
                        dSalario1 = dHoras1 * 9.75;
                    }
                    else{
                        dSalario1 = ((dHoras1 - 160) * 11.50) + (160 * 9.75);
                    }

                    dIsss1 = dSalario1 * 0.0525;
                    dAfp1 = dSalario1 * 0.0688;
                    dRenta1 = dSalario1 * 0.1;
                    dLiquido1 = dSalario1 - dIsss1 - dAfp1 - dRenta1;

                    strsEmpleado1 = new String[]{etNombre1.getText().toString(), etApellido1.getText().toString(), spCargo1.getSelectedItem().toString(), etHoras1.getText().toString(),
                    String.valueOf(dIsss1),String.valueOf(dAfp1),String.valueOf(dRenta1),String.valueOf(dLiquido1)};

                    if(dHoras2 <= 160){
                        dSalario2 = dHoras2 * 9.75;
                    }
                    else{
                        dSalario2 = ((dHoras2 - 160) * 11.50) + (160 * 9.75);
                    }

                    dIsss2 = dSalario2 * 0.0525;
                    dAfp2 = dSalario2 * 0.0688;
                    dRenta2 = dSalario2 * 0.1;
                    dLiquido2 = dSalario2 - dIsss2 - dAfp2 - dRenta2;

                    strsEmpleado2 = new String[]{etNombre2.getText().toString(), etApellido2.getText().toString(), spCargo2.getSelectedItem().toString(), etHoras2.getText().toString(),
                            String.valueOf(dIsss2),String.valueOf(dAfp2),String.valueOf(dRenta2),String.valueOf(dLiquido2)};

                    if(dHoras3 <= 160){

                        dSalario3 = dHoras3 * 9.75;
                    }
                    else{
                        dSalario3 = ((dHoras3 - 160) * 11.50) + (160 * 9.75);
                    }

                    dIsss3 = dSalario3 * 0.0525;
                    dAfp3 = dSalario3 * 0.0688;
                    dRenta3 = dSalario3 * 0.1;
                    dLiquido3 = dSalario3 - dIsss3 - dAfp3 - dRenta3;

                    strsEmpleado3 = new String[]{etNombre3.getText().toString(), etApellido3.getText().toString(), spCargo3.getSelectedItem().toString(), etHoras3.getText().toString(),
                            String.valueOf(dIsss3),String.valueOf(dAfp3),String.valueOf(dRenta3),String.valueOf(dLiquido3)};

                    Intent segundaActividadIntent = new Intent(getApplicationContext(), segundaActividad.class);
                    segundaActividadIntent.putExtra("arrayEmpleado1", strsEmpleado1);
                    segundaActividadIntent.putExtra("arrayEmpleado2", strsEmpleado2);
                    segundaActividadIntent.putExtra("arrayEmpleado3", strsEmpleado3);
                    //segundaActividadIntent.putExtra("txtRaiz2", String.valueOf(dRaiz2));
                    startActivity(segundaActividadIntent);
                }
            }
        });
    }

    private boolean validarNombres(EditText p_etNombre1, EditText p_etNombre2, EditText p_etNombre3){
        String strNombre1 = p_etNombre1.getText().toString();
        String strNombre2 = p_etNombre2.getText().toString();
        String strNombre3 = p_etNombre3.getText().toString();

        if(strNombre1.isEmpty() || strNombre2.isEmpty() || strNombre3.isEmpty()){
            return true;
        }

        return false;
    }

    private boolean validarApellidos(EditText p_etApellido1, EditText p_etApellido2, EditText p_etApellido3){
        String strApellido1 = p_etApellido1.getText().toString();
        String strApellido2 = p_etApellido2.getText().toString();
        String strApellido3 = p_etApellido3.getText().toString();

        if(strApellido1.isEmpty() || strApellido2.isEmpty() || strApellido3.isEmpty() ){
            return true;
        }

        return false;
    }

    private boolean validarHoras(EditText p_etHoras1, EditText p_etHoras2, EditText p_etHoras3){
        if(p_etHoras1.getText().toString().isEmpty() || p_etHoras2.getText().toString().isEmpty() || p_etHoras3.getText().toString().isEmpty()){
            return true;
        }
        else if(Double.parseDouble(p_etHoras1.getText().toString()) <= 0 || Double.parseDouble(p_etHoras2.getText().toString()) <= 0 || Double.parseDouble(p_etHoras3.getText().toString()) <= 0){
            return true;
        }

        return false;
    }
}