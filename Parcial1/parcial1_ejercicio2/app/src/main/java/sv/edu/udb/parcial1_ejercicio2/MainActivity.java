package sv.edu.udb.parcial1_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText etVotos;
    TextView tvResultado;
    Button btnCalcular;
    int iVotos1 = 0,iVotos2 = 0,iVotos3 = 0,iVotos4 = 0,iVoto,iTotalVotos;
    double dVotos1,dVotos2,dVotos3,dVotos4;
    String strVotos;
    String[] strSplitVotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVotos = (EditText) findViewById(R.id.ptVotos);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               strVotos = etVotos.getText().toString();
               strSplitVotos = strVotos.split(",",0);
               iTotalVotos = strSplitVotos.length;
               iVotos1 = 0;
               iVotos2 = 0;
               iVotos3 = 0;
               iVotos4 = 0;

                for(String str : strSplitVotos){
                    iVoto = Integer.parseInt(str);

                    switch(iVoto) {
                        case 1:
                            iVotos1++;
                            break;
                        case 2:
                            iVotos2++;
                            break;
                        case 3:
                            iVotos3++;
                            break;
                        case 4:
                            iVotos4++;
                            break;
                        default:
                            iTotalVotos--;
                    }
                }

                DecimalFormat df2 = new DecimalFormat("#.##");

                dVotos1 = iVotos1 * 100 / iTotalVotos;
                dVotos2 = iVotos2 * 100 / iTotalVotos;
                dVotos3 = iVotos3 * 100 / iTotalVotos;
                dVotos4 = iVotos4 * 100 / iTotalVotos;

                tvResultado.setText("El resultado de los votos es: "
                        + System.getProperty ("line.separator") +
                        "Primer candidato:  " + dVotos1 + "%" + " con " + String.valueOf(iVotos1) + " votos a su favor."
                        + System.getProperty ("line.separator") +
                        "Segundo candidato: " + dVotos2 + "%" + " con " + String.valueOf(iVotos2) + " votos a su favor."
                        + System.getProperty ("line.separator") +
                        "Tercer candidato: " + dVotos3 + "%" + " con " + String.valueOf(iVotos3) + " votos a su favor."
                        + System.getProperty ("line.separator") +
                        "Cuarto candidato: " + dVotos4 + "%" + " con " + String.valueOf(iVotos4) + " votos a su favor.");

            }
        });
    }
}