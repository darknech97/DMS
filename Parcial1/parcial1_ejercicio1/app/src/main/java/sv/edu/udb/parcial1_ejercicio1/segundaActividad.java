package sv.edu.udb.parcial1_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class segundaActividad extends AppCompatActivity {

    Bundle bBundle;
    String strRaiz1,strRaiz2;
    TextView tvRaiz1, tvRaiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        bBundle = getIntent().getExtras();
        strRaiz1 = bBundle.getString("txtRaiz1");
        strRaiz2 = bBundle.getString("txtRaiz2");

        tvRaiz1 = (TextView)findViewById(R.id.tvRaiz1);
        tvRaiz2 = (TextView)findViewById(R.id.tvRaiz2);
        tvRaiz1.setText("Raiz 1: " + strRaiz1);
        tvRaiz2.setText("Raiz 1: " + strRaiz2);
    }


    public void finalizar(View v) {
        finish();
    }
}
