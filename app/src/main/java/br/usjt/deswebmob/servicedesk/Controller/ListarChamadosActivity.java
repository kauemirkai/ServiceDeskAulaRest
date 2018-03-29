package br.usjt.deswebmob.servicedesk.Controller;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.deswebmob.servicedesk.Model.Chamado;
import br.usjt.deswebmob.servicedesk.Model.ChamadoAdapter;
import br.usjt.deswebmob.servicedesk.Model.ChamadoNetwork;
import br.usjt.deswebmob.servicedesk.R;

public class ListarChamadosActivity extends Activity {
    public static final String DESCRICAO =
            "br.usjt.deswebmob.servicedesk.descricao";
    ArrayList<Chamado> chamados;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        atividade = this;
        Intent intent = getIntent();
        chamados = (ArrayList<Chamado>)intent.getSerializableExtra(MainActivity.CHAMADOS);
        String chave = intent.getStringExtra(MainActivity.CHAMADOS);
        ListView listView = (ListView) findViewById(R.id.listview);
        ChamadoAdapter adapter = new ChamadoAdapter(this, chamados);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new
                                                AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view,
                                                                            int position, long id) {
                                                        // manda para a tela de detalhe
                                                        Intent intent = new Intent(atividade,
                                                                DetalheChamadoActivity.class);
                                                        intent.putExtra(DESCRICAO, chamados.get(position));
                                                        startActivity(intent);
                                                    }
                                                });
    }


}