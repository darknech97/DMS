package sv.edu.udb.guia03app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Declaracion de variables
    Button btnAgregar;
    TextView txtNumero;
    int iNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciliziacion de variables
        btnAgregar = findViewById(R.id.btnAgregar);
        txtNumero = findViewById(R.id.txtNumero);
        iNumero = 0;

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumarNumero();
            }
        });

        txtNumero.setText(String.valueOf(iNumero));

    }

    public void sumarNumero(){
        if(iNumero == 9){
            iNumero = 0;
        }
        iNumero++;
        txtNumero.setText(String.valueOf(iNumero));
    }
}