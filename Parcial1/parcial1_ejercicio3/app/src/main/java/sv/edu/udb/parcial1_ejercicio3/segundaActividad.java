package sv.edu.udb.parcial1_ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class segundaActividad extends AppCompatActivity {

    Bundle bBundle;
    String[] strsEmpleado1,strsEmpleado2,strsEmpleado3;
    double dLiquido1,dLiquido2,dLiquido3;
    double dBono1,dBono2,dBono3;
    TextView tvEmpleado1,tvEmpleado2,tvEmpleado3,tvMayor, tvMenor, tv300;
    private static DecimalFormat df = new DecimalFormat("#.##");
    boolean bBono = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        bBundle = getIntent().getExtras();
        strsEmpleado1 = bBundle.getStringArray("arrayEmpleado1");
        strsEmpleado2 = bBundle.getStringArray("arrayEmpleado2");
        strsEmpleado3 = bBundle.getStringArray("arrayEmpleado3");
        //strsEmpleado1 = bBundle.getString("arrayEmpleado1");

        tvEmpleado1 = (TextView) findViewById(R.id.tvEmpleado1);
        tvEmpleado2 = (TextView) findViewById(R.id.tvEmpleado2);
        tvEmpleado3 = (TextView) findViewById(R.id.tvEmpleado3);

        tvMayor = (TextView) findViewById(R.id.tvMayor);
        tvMenor = (TextView) findViewById(R.id.tvMenor);
        tv300 = (TextView) findViewById(R.id.tv300);

        if(strsEmpleado1[2].equals("Gerente") && strsEmpleado2[2].equals("Asistente") && strsEmpleado3[2].equals("Secretaria")){
            dBono1 = 0;
            dBono2 = 0;
            dBono3 = 0;

            bBono = false;
        }
        else{
            dLiquido1 = Double.parseDouble(strsEmpleado1[7]);
            dLiquido2 = Double.parseDouble(strsEmpleado2[7]);
            dLiquido3 = Double.parseDouble(strsEmpleado3[7]);

            switch(strsEmpleado1[2]) {
                case "Gerente":
                    dBono1 = dLiquido1 * 0.1;
                    break;
                case "Asistente":
                    dBono1 = dLiquido1 * 0.05;
                    break;
                case "Secretaria":
                    dBono1 = dLiquido1 * 0.03;
                    break;
                default:
                    dBono1 = dLiquido1 * 0.02;
            }

            switch(strsEmpleado2[2]) {
                case "Gerente":
                    dBono2 = dLiquido2 * 0.1;
                    break;
                case "Asistente":
                    dBono2 = dLiquido2 * 0.05;
                    break;
                case "Secretaria":
                    dBono2 = dLiquido2 * 0.03;
                    break;
                default:
                    dBono2 = dLiquido2 * 0.02;
            }

            switch(strsEmpleado3[2]) {
                case "Gerente":
                    dBono3 = dLiquido3 * 0.1;
                    break;
                case "Asistente":
                    dBono3 = dLiquido3 * 0.05;
                    break;
                case "Secretaria":
                    dBono3 = dLiquido3 * 0.03;
                    break;
                default:
                    dBono3 = dLiquido3 * 0.02;
            }
        }

        if(bBono == true){
            dLiquido1 = dLiquido1 + dBono1;
            dLiquido2 = dLiquido2 + dBono2;
            dLiquido3 = dLiquido3 + dBono3;

            tvEmpleado1.setText("EMPLEADO NUMERO 1"
                    + System.getProperty ("line.separator") +
                    "Nombre: " + strsEmpleado1[0]
                    + System.getProperty ("line.separator") +
                    "ISSS: " + df.format(Double.parseDouble(strsEmpleado1[4]))
                    + System.getProperty ("line.separator") +
                    "AFP: " + df.format(Double.parseDouble(strsEmpleado1[5]))
                    + System.getProperty ("line.separator") +
                    "RENTA: " + df.format(Double.parseDouble(strsEmpleado1[6]))
                    + System.getProperty ("line.separator") +
                    "Sueldo Liquido: " + df.format(Double.parseDouble(strsEmpleado1[7]))
                    + System.getProperty ("line.separator") +
                    "Bono: " + df.format(dBono1)
                    + System.getProperty ("line.separator") +
                    "Salario Final: " + df.format(dLiquido1));

            tvEmpleado2.setText("EMPLEADO NUMERO 2"
                    + System.getProperty ("line.separator") +
                    "Nombre: " + strsEmpleado2[0]
                    + System.getProperty ("line.separator") +
                    "ISSS: " + df.format(Double.parseDouble(strsEmpleado2[4]))
                    + System.getProperty ("line.separator") +
                    "AFP: " + df.format(Double.parseDouble(strsEmpleado2[5]))
                    + System.getProperty ("line.separator") +
                    "RENTA: " + df.format(Double.parseDouble(strsEmpleado2[6]))
                    + System.getProperty ("line.separator") +
                    "Sueldo Liquido: " + df.format(Double.parseDouble(strsEmpleado2[7]))
                    + System.getProperty ("line.separator") +
                    "Bono: " + df.format(dBono2)
                    + System.getProperty ("line.separator") +
                    "Salario Final: " + df.format(dLiquido2));

            tvEmpleado3.setText("EMPLEADO NUMERO 3"
                    + System.getProperty ("line.separator") +
                    "Nombre: " + strsEmpleado3[0]
                    + System.getProperty ("line.separator") +
                    "ISSS: " + df.format(Double.parseDouble(strsEmpleado3[4]))
                    + System.getProperty ("line.separator") +
                    "AFP: " + df.format(Double.parseDouble(strsEmpleado3[5]))
                    + System.getProperty ("line.separator") +
                    "RENTA: " + df.format(Double.parseDouble(strsEmpleado3[6]))
                    + System.getProperty ("line.separator") +
                    "Sueldo Liquido: " + df.format(Double.parseDouble(strsEmpleado3[7]))
                    + System.getProperty ("line.separator") +
                    "Bono: " + df.format(dBono3)
                    + System.getProperty ("line.separator") +
                    "Salario Final: " + df.format(dLiquido3));
        }
        else{
            dLiquido1 = dLiquido1 + dBono1;
            dLiquido2 = dLiquido2 + dBono2;
            dLiquido3 = dLiquido3 + dBono3;

            tvEmpleado1.setText("EMPLEADO NUMERO 1"
                    + System.getProperty ("line.separator") +
                    "Nombre: " + strsEmpleado1[0]
                    + System.getProperty ("line.separator") +
                    "ISSS: " + df.format(Double.parseDouble(strsEmpleado1[4]))
                    + System.getProperty ("line.separator") +
                    "AFP: " + df.format(Double.parseDouble(strsEmpleado1[5]))
                    + System.getProperty ("line.separator") +
                    "RENTA: " + df.format(Double.parseDouble(strsEmpleado1[6]))
                    + System.getProperty ("line.separator") +
                    "Sueldo Liquido: " + df.format(Double.parseDouble(strsEmpleado1[7]))
                    + System.getProperty ("line.separator") +
                    "NO HAY BONO"
                    + System.getProperty ("line.separator") +
                    "Salario Final: " + df.format(dLiquido1));

            tvEmpleado2.setText("EMPLEADO NUMERO 2"
                    + System.getProperty ("line.separator") +
                    "Nombre: " + strsEmpleado2[0]
                    + System.getProperty ("line.separator") +
                    "ISSS: " + df.format(Double.parseDouble(strsEmpleado2[4]))
                    + System.getProperty ("line.separator") +
                    "AFP: " + df.format(Double.parseDouble(strsEmpleado2[5]))
                    + System.getProperty ("line.separator") +
                    "RENTA: " + df.format(Double.parseDouble(strsEmpleado2[6]))
                    + System.getProperty ("line.separator") +
                    "Sueldo Liquido: " + df.format(Double.parseDouble(strsEmpleado2[7]))
                    + System.getProperty ("line.separator") +
                    "NO HAY BONO"
                    + System.getProperty ("line.separator") +
                    "Salario Final: " + df.format(dLiquido2));

            tvEmpleado3.setText("EMPLEADO NUMERO 3"
                    + System.getProperty ("line.separator") +
                    "Nombre: " + strsEmpleado3[0]
                    + System.getProperty ("line.separator") +
                    "ISSS: " + df.format(Double.parseDouble(strsEmpleado3[4]))
                    + System.getProperty ("line.separator") +
                    "AFP: " + df.format(Double.parseDouble(strsEmpleado3[5]))
                    + System.getProperty ("line.separator") +
                    "RENTA: " + df.format(Double.parseDouble(strsEmpleado3[6]))
                    + System.getProperty ("line.separator") +
                    "Sueldo Liquido: " + df.format(Double.parseDouble(strsEmpleado3[7]))
                    + System.getProperty ("line.separator") +
                    "NO HAY BONO"
                    + System.getProperty ("line.separator") +
                    "Salario Final: " + df.format(dLiquido3));
        }

        if(dLiquido1 > dLiquido2 && dLiquido1 > dLiquido3){
            tvMayor.setText("El primer empleado tiene el mayor salario.");
        }
        else if(dLiquido2 > dLiquido1 && dLiquido2 > dLiquido3){
            tvMayor.setText("El segundo empleado tiene el mayor salario.");
        }
        else if(dLiquido3 > dLiquido1 && dLiquido3 > dLiquido2){
            tvMayor.setText("El tercer empleado tiene el mayor salario.");
        }


        if(dLiquido1 < dLiquido2 && dLiquido1 < dLiquido3){
            tvMenor.setText("El primer empleado tiene el menor salario.");
        }
        else if(dLiquido2 < dLiquido1 && dLiquido2 < dLiquido3){
            tvMenor.setText("El segundo empleado tiene el menor salario.");
        }
        else if(dLiquido3 < dLiquido1 && dLiquido3 < dLiquido2){
            tvMenor.setText("El tercer empleado tiene el menor salario.");
        }

        int i300 = 0;

        if(dLiquido1 > 300){
            i300++;
        }

        if(dLiquido2 > 300){
            i300++;
        }

        if(dLiquido3 > 300){
            i300++;
        }

        tv300.setText("Hay " + i300 + " empleados con salario mayor a 300.");

    }

    public void finalizar(View v) {
        finish();
    }
}