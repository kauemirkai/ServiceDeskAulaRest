package br.usjt.deswebmob.servicedesk.Controller;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.deswebmob.servicedesk.Controller.ListarChamadosActivity;
import br.usjt.deswebmob.servicedesk.Model.Chamado;
import br.usjt.deswebmob.servicedesk.Model.ChamadoNetwork;
import br.usjt.deswebmob.servicedesk.R;

public class MainActivity extends Activity {
    private EditText txtNome;
    Context contexto;
    public static final String CHAMADOS = "br.usjt.deswebmob.servicedesk.CHAMADOS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        contexto = this;

    }
    public void buscarChamados(View view){
        Intent intent = new Intent(this, ListarChamadosActivity.class);
        String nome = txtNome.getText().toString();
        intent.putExtra(CHAMADOS, nome);
        startActivity(intent);
    }

    private class  DownloadJsonChamados extends AsyncTask<String, Void,ArrayList<Chamado>>{

        protected ArrayList<Chamado> doInBackground(String... strings) {
            ArrayList<Chamado> chamados = new ArrayList<>();
            try {
                chamados = ChamadoNetwork.buscarChamados("http://10.71.4.167:8080/arqse_sdesk_a4_solucao_parcial");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return chamados;

        }
        protected  void onPostExecute(ArrayList<Chamado> chamados){
            Intent intent = new Intent(contexto, ListarChamadosActivity.class);
            intent.putExtra(CHAMADOS, chamados);
            startActivity(intent);

        }
        }


}
