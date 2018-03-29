package br.usjt.deswebmob.servicedesk.Controller;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.deswebmob.servicedesk.Controller.ListarChamadosActivity;
import br.usjt.deswebmob.servicedesk.Model.Chamado;
import br.usjt.deswebmob.servicedesk.Model.Fila;
import br.usjt.deswebmob.servicedesk.Model.Util;
import br.usjt.deswebmob.servicedesk.R;

public class DetalheChamadoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_chamado);
        Intent intent = getIntent();
        Chamado chamado = (Chamado)intent.getSerializableExtra(ListarChamadosActivity.DESCRICAO);
        ImageView foto = (ImageView) findViewById(R.id.foto_fila_detalhe);
        Drawable drawable = Util.getDrawabkeDinamic(this, chamado.getFila().getFigura());
        foto.setImageDrawable(drawable);
        TextView fila = (TextView)findViewById(R.id.valor_fila);

        fila.setText(chamado.getFila().getNome());
        TextView numero = (TextView)findViewById(R.id.valor_numero);
        numero.setText(""+chamado.getNumero());
        TextView status = (TextView)findViewById(R.id.valor_status);
        status.setText(""+chamado.getStatus());
        TextView abertura = (TextView)findViewById(R.id.valor_abertura);
        abertura.setText(String.format("%tD",chamado.getDataAbertura()));
        TextView fechamento = (TextView)findViewById(R.id.valor_fechamento);
        String strFechamento = String.format("%tD",chamado.getDataFechamento());
        fechamento.setText(strFechamento.equals("null")?" ":strFechamento);
        TextView descricao = (TextView)findViewById(R.id.valor_descricao);
        descricao.setText(""+chamado.getDescricao());
    }
}
