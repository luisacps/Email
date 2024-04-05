package santos.pimentel.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

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

                // obtencao da caixa de texto de email
                EditText etEmail = findViewById(R.id.etEmail);
                // captura do texto digitado na caixa
                String email = etEmail.getText().toString();

                // obtencao da caixa de texto de assunto
                EditText etAssunto = findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();

                // obtencao da caixa de texto extenso
                EditText etTexto = findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();

                // criacao de uma intent sem tela destino especifica, que procura no android apps que possam executar a acao sendto
                Intent i = new Intent(Intent.ACTION_SENDTO);
                // especificacao de que a intent deve procurar apenas apps que facam envio e recebimento de email
                i.setData(Uri.parse("mailto:"));

                // criacao de uma array que vai conter todas as informacoes do email que vai ser enviado para a aplicacao externa
                String[] emails = new String[] {email};
                // informacao 1 - o email do destinatario
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                // informacao 2 - o campo de assunto
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                // informacao 3 - o campo de texto
                i.putExtra(Intent.EXTRA_TEXT, texto);

                // tentativa de execucao da intent, o createChooser permite que o usuario escolha a aplicacao que envia email entre as encontradas
                // o catch e executado caso nao tenha nenhuma app que faca envio de email
                try {
                    startActivity (Intent.createChooser(i, "escolha o app"));
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "nao e possivel realizar a operacao em nenhum app",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}