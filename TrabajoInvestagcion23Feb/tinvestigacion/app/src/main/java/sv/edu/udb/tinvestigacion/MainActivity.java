package sv.edu.udb.tinvestigacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txtTexto;
    Button btnConvertir;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto = (TextView)findViewById(R.id.txtTexto);
        btnConvertir = (Button)findViewById(R.id.btnConvertir);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    Locale locSpanish = new Locale("spa", "MEX");
                    textToSpeech.setLanguage(locSpanish);
                }
                else{
                    Toast.makeText( getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strTexto = txtTexto.getText().toString().trim();
                textToSpeech.speak(strTexto, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    @Override
    protected  void onPause(){
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }



}