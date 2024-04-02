package santos.pimentel.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // capturando o botao
        Button btnEnviar = findViewById(R.id.btnEnviar);
        // setando uma acao que ocorre com o clique no botao
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();

                EditText etAssunto = findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();

                EditText etTexto = findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();
            }
        });
    }
}