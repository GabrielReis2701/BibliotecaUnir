package com.unir.bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnPesquisar,bt_remover,bt_alterarR;
    private RadioGroup rd_PesquisarPor;
    private EditText edtPesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btn_cadastrar);
        bt_remover = findViewById(R.id.bt_remover);
        bt_alterarR = findViewById(R.id.bt_alterar);
        btnPesquisar = findViewById(R.id.btn_pesquisar);
        rd_PesquisarPor = findViewById(R.id.rb_pesquisar);
        edtPesquisar = findViewById(R.id.edt_pesquisar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Pesquisa.class);
                int id = rd_PesquisarPor.getCheckedRadioButtonId();
                String busca = edtPesquisar.getText().toString();
                intent.putExtra("tipo", id);
                intent.putExtra("busca", busca);
                startActivity(intent);
            }
        });
        bt_remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RemoverLivro.class);
                startActivity(i);
            }
        });
        bt_alterarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AlterarRegistro.class);
                startActivity(i);
            }
        });

    }
}