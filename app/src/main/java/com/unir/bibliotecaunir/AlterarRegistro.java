package com.unir.bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarRegistro extends AppCompatActivity {

    private EditText et_id,et_titulo,et_ano,et_autor;
    private Button bt_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_registro);

        et_titulo = findViewById(R.id.et_tituloAR);
        et_ano = findViewById(R.id.et_anoAR);
        et_autor = findViewById(R.id.et_autorAR);
        et_id = findViewById(R.id.et_idAR);
        bt_confirmar = findViewById(R.id.bt_confirmarAR);
        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo,autor;
                int ano, id = Integer.parseInt(et_id.getText().toString());
                titulo = et_titulo.getText().toString();
                ano = Integer.parseInt(et_ano.getText().toString());
                autor = et_autor.getText().toString();
                BancoControlador bd = new BancoControlador(getApplicationContext());
                bd.alterarRegistro(id,titulo,autor,ano);

                Toast.makeText(AlterarRegistro.this, "Livro alterado com sucesso!", Toast.LENGTH_SHORT).show();

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onBackPressed();
                    }
                }, 1000);
            }
        });
    }
}