package br.com.metting.www.likemeet.Class;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by wisti on 03/12/2016.
 */
public class Evento {

    int id;
    int idUsuarioCadastrou;
    String Nome;
    String local;
    String endereco;
    Date dataEvento;//(data em que o evento vai ocorrer)
    Double valorEntrada;//(caso haja valor de entrada a ser cobrado)
    int qtdMax;//(quantidade maxima de pessoas)
    String descricao;
    int privado;//(se o evento for privado apenas o admin podera adicionar as pessoas ao evento)
    int idCategoria;//(jogos,festa,bares,shows)
    int idadeMin;// (idade minina restringida ao usuario)


    public Evento(int id, int idUsuarioCadastrou, String nome, String local, String endereco, Date dataEvento, Double valorEntrada, int qtdMax, String descricao, int privado, int idCategoria, int idadeMin) {
        this.id = id;
        this.idUsuarioCadastrou = idUsuarioCadastrou;
        Nome = nome;
        this.local = local;
        this.endereco = endereco;
        this.dataEvento = dataEvento;
        this.valorEntrada = valorEntrada;
        this.qtdMax = qtdMax;
        this.descricao = descricao;
        this.privado = privado;
        this.idCategoria = idCategoria;
        this.idadeMin = idadeMin;
    }

    public void cadastrarEvento(int id, int idUsuarioCadastrou, String nome, String local, String endereco, Date dataEvento, Double valorEntrada, int qtdMax, String descricao, int privado, int idCategoria, int idadeMin){

    }
    public void getListaEventos(){

    }

    public int getId() {
        return id;
    }

    public int getIdUsuarioCadastrou() {
        return idUsuarioCadastrou;
    }

    public String getNome() {
        return Nome;
    }

    public String getLocal() {
        return local;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public String getEndereco() {
        return endereco;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrivado() {
        return privado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdadeMin() {
        return idadeMin;
    }
}
