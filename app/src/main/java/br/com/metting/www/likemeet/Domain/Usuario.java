package br.com.metting.www.likemeet.Domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexandre Andrade on 16/12/2016.
 */
public class Usuario {

    private int id;
    private String nome;
    private String telefone;
    private Date nascimento;
    private String foto;
    private boolean ativo;
    private int qnt_evento_cadastrado;
    private String codigo_ativo;
    private boolean vip;
    private String gcm;

    public Usuario() {
    }

    public Usuario(int id, String nome, String telefone, Date nascimento, String foto, boolean ativo, int qnt_evento_cadastrado, String codigo_ativo, boolean vip, String gcm) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.foto = foto;
        this.ativo = ativo;
        this.qnt_evento_cadastrado = qnt_evento_cadastrado;
        this.codigo_ativo = codigo_ativo;
        this.vip = vip;
        this.gcm = gcm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getQnt_evento_cadastrado() {
        return qnt_evento_cadastrado;
    }

    public void setQnt_evento_cadastrado(int qnt_evento_cadastrado) {
        this.qnt_evento_cadastrado = qnt_evento_cadastrado;
    }

    public String getCodigo_ativo() {
        return codigo_ativo;
    }

    public void setCodigo_ativo(String codigo_ativo) {
        this.codigo_ativo = codigo_ativo;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getGcm() {
        return gcm;
    }

    public void setGcm(String gcm) {
        this.gcm = gcm;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nascimento=" + nascimento +
                ", foto='" + foto + '\'' +
                ", ativo=" + ativo +
                ", qnt_evento_cadastrado=" + qnt_evento_cadastrado +
                ", codigo_ativo='" + codigo_ativo + '\'' +
                ", vip=" + vip +
                ", gcm='" + gcm + '\'' +
                '}';
    }

    public String getParametros() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "id=" + id + "&nome=" + nome + "&telefone=" + telefone + "&"
                + "nascimento=" + format.format(nascimento) + "&foto=" + foto + "&ativo=" + ativo + "&"
                + "qnt_evento_cadastrado=" + qnt_evento_cadastrado + "&"
                + "codigo_ativo=" + codigo_ativo + "&vip=" + vip+"&gcm_code="+gcm;
    }

}
