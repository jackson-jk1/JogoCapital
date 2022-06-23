package com.example.jogocapitalapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public List<Estado> estadosList = getEstados();
    public Estado estadoPgt;
    public int pontos;
    public int vezes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sortEstado();
    }

    public void getResposta(View view){
        vezes = vezes + 1;
        EditText pergunta = findViewById(R.id.pergunta);
        if(pergunta.getText().toString().equals("")){
            Toast.makeText(this,"Insira uma nome valido", Toast.LENGTH_SHORT).show();
            return;

        }
        if(vezes == 5){
            Button enviar = findViewById(R.id.enviar);
            Button proximo = findViewById(R.id.proximo);
            Button reiniciar = findViewById(R.id.reiniciar);
            enviar.setEnabled(false);
            proximo.setEnabled(false);
            reiniciar.setVisibility(view.VISIBLE);
            enviar.setVisibility(view.INVISIBLE);
            proximo.setVisibility(view.INVISIBLE);
            return;
        }
        Button enviar = findViewById(R.id.enviar);
        enviar.setEnabled(false);
        TextView pt = findViewById(R.id.pontuacao);
        TextView resp = findViewById(R.id.resposta);
        if(pergunta.getText().toString().equals(estadoPgt.Capital.Nome)){
            pontos = pontos + 10;
            pt.setText("Pontuação: " + String.valueOf(pontos));
            resp.setText("Acertou");
            estadosList.remove(estadoPgt);
            return;
        }
        pt.setText("Pontuação: " + String.valueOf(pontos));
        resp.setText("Errou");
    }
    public void sortEstado(){
        TextView estado = findViewById(R.id.estado);
        Random random = new Random();
        estadoPgt = estadosList.get(random.nextInt(estadosList.size()));
        estado.setText(estadoPgt.getNome());
    }
    public void proximaPergunta(View view){
        TextView resp = findViewById(R.id.resposta);
        EditText perg = findViewById(R.id.pergunta);
        perg.setText("");
        resp.setText("");
        this.sortEstado();
        Button enviar = findViewById(R.id.enviar);
        enviar.setEnabled(true);


    }

    public void reiniciar(View view){
        estadosList = getEstados();
        vezes = 0;
        pontos = 0;
        Button enviar = findViewById(R.id.enviar);
        Button proximo = findViewById(R.id.proximo);
        Button reiniciar = findViewById(R.id.reiniciar);
        reiniciar.setVisibility(view.INVISIBLE);
        enviar.setVisibility(view.VISIBLE);
        proximo.setVisibility(view.VISIBLE);
        proximo.setEnabled(true);
        enviar.setEnabled(true);
        TextView resp = findViewById(R.id.resposta);
        EditText perg = findViewById(R.id.pergunta);
        TextView pt = findViewById(R.id.pontuacao);
        perg.setText("");
        resp.setText("");
        pt.setText("");
        this.sortEstado();

    }

    public List<Estado> getEstados(){
        List<Estado> listEstados = new ArrayList<Estado>();

        listEstados.add(new Estado("Parana",new Capital("Curitiba")));
        listEstados.add(new Estado("Santa Catarina",new Capital("Florianopolis")));
        listEstados.add(new Estado("Distrito Federal",new Capital("Brasilha")));
        listEstados.add(new Estado("Minas Gerais",new Capital("Belo Horizonte")));
        listEstados.add(new Estado("Pernanbuco",new Capital("Recife")));
        listEstados.add(new Estado("Espirito Santo",new Capital("Vitoria")));
        listEstados.add(new Estado("Mato grosso",new Capital("Cuiaba")));
        listEstados.add(new Estado("Rondonia",new Capital("Porto Velho")));
        listEstados.add(new Estado("Bahia",new Capital("Salvador")));
        listEstados.add(new Estado("Alagoas",new Capital("Maceio")));
        listEstados.add(new Estado("Manaus",new Capital("Amazonas")));
        listEstados.add(new Estado("Acre",new Capital("Rio Branco")));
        listEstados.add(new Estado("Roraima",new Capital("Boa vista")));
        listEstados.add(new Estado("Sergipe",new Capital("Aracaju")));
        listEstados.add(new Estado("Ceara",new Capital("Fortaleza")));

        return listEstados;
    }
}