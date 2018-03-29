package br.usjt.deswebmob.servicedesk.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by arqdsis on 21/03/2018.
 */

public class Chamado implements Serializable {
    private int numero;
    private Date dataAbertura , dataFechamento;
    private String status, descricao;
    private Fila fila;


    public static final String ABERTO="aberto";
    public static final String FECHADO="fechado";

    public Chamado(int numero, Date dataAbertura, Date dataFechamento, String status, String descricao, Fila fila) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.fila = fila;
    }
    public Chamado (){}

    public int getNumero() {
        return numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public Fila getFila() {
        return fila;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {
        return fila.getNome() + descricao;
    }
}
