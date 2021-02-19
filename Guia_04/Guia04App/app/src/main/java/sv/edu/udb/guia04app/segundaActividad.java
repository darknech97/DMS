package sv.edu.udb.guia04app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class segundaActividad extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvEdad;
    private TextView txtSalario, txtIsss, txtAfp, txtRenta, txtSalarioFinal;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        tvNombre=(TextView)findViewById(R.id.textViewNombre);
        tvEdad=(TextView)findViewById(R.id.textViewEdad);
        Bundle bundle = getIntent().getExtras();
        String nombre=bundle.getString("txtNombre");
        String edad=bundle.getString("txtEdad");
        tvNombre.setText("Nombre: " + nombre);
        tvEdad.setText("Horas Trabajadas: " + edad);


        double dSalario = Float.parseFloat(bundle.getString("txtEdad")) * 8.5;
        double dIsss = dSalario * 0.02;
        double dAfp = dSalario * 0.03;
        double dRenta = dSalario * 0.04;
        double dSalarioFinal = dSalario - dIsss - dAfp - dRenta;

        txtSalario = (TextView)findViewById(R.id.txtSalario);
        txtIsss = (TextView)findViewById(R.id.txtIsss);
        txtAfp = (TextView)findViewById(R.id.txtAfp);
        txtRenta = (TextView)findViewById(R.id.txtRenta);
        txtSalarioFinal = (TextView)findViewById(R.id.txtSalarioFinal);

        txtSalario.setText("Salario: " + df2.format(dSalario));
        txtIsss.setText("ISSS: " + df2.format(dIsss));
        txtAfp.setText("AFP: " + df2.format(dAfp));
        txtRenta.setText("Renta: " + df2.format(dRenta));
        txtSalarioFinal.setText("Salario Final:" + df2.format(dSalarioFinal));
    }

    public void finalizar(View v) {
        finish();
    }
}