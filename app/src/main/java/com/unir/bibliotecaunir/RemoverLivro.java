package com.unir.bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RemoverLivro extends AppCompatActivity {

    private TextInputEditText et_id;
    private Button bt_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_livro);

        bt_confirmar = findViewById(R.id.bt_confirmarRemove);
        et_id = findViewById(R.id.et_idRemove);

        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(et_id.getText().toString());
                BancoControlador bd = new BancoControlador(getApplicationContext());
                bd.deletarRegistro(id);
                Toast.makeText(RemoverLivro.this, "Livro removido com sucesso!!", Toast.LENGTH_SHORT).show();
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