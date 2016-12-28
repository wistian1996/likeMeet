package br.com.metting.www.likemeet.Class;

import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public Evento() {

    }


    public static ArrayList<Evento> getListaEventos() {
        java.util.Date data1 = new java.util.Date();

        Date data = new Date(data1.getTime());


        // Usuário informa uma data
        java.util.Date data2 = new java.util.Date();
// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia nela
        Calendar c = Calendar.getInstance();
        c.setTime(data2);
        c.add(Calendar.DATE, +1);
// Obtemos a data alterada
        data2 = c.getTime();

        Date data3 = new Date(data2.getTime());

        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        // OU
        //-10.976572,-37.064738

        //  SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
        Evento evento = new Evento(1, 1, "Quadra do melhores", "-10.937351,-37.082956", "Sem referencia", data3 , 0.0, 50, "Bora galera, bater um baba!!!!", 0, 4, 10);
        Evento evento3 = new Evento(3, 1, "Festeja fest", "-10.942671,-37.097429", "Sem referencia", data, 120.00, 50, "Festa particular!", 0, 1, 18);
        Evento evento4 = new Evento(4, 1, "Show ao vivo, Ludos pub", "-10.970726,-37.054052", "Sem referencia", data, 0.0, 50, "Bar com show ao vivo!", 0, 2, 18);
        Evento evento2 = new Evento(2, 1, "Truco dos paulista", "-10.970726,-37.054052", "Sem referencia", data, 0.0, 50, "Partida amistosa de truco", 0, 3, 12);

        Evento evento5 = new Evento(5, 1, "Feijão com tranqueira", "-10.991158,-37.051060", "Sem referencia", data, 0.0, 50, "Bar com show ao vivo!", 0, 2, 18);

        Evento evento6 = new Evento(6, 1, "Cariri", "-10.994223,-37.053079", "Sem referencia", data, 0.0, 50, "Bar com show ao vivo!", 0, 2, 18);

        Evento evento7 = new Evento(7, 1, "SEMPESQ , UNIT", "-10.967741,-37.058704", "Sem referencia", data3, 0.0, 50, "13º SEMPESQ da UNIT!", 0, 7, 16);

        ArrayList<Evento> lista = new ArrayList<>();
        lista.add(evento3);
        lista.add(evento4);
        lista.add(evento2);
        lista.add(evento);
        lista.add(evento5);
        lista.add(evento6);
        lista.add(evento7);

        return lista;
    }

    public Evento getEvento(int id) {
        for (Evento list : getListaEventos()
                ) {
            if (list.getId() == id) {
                return list;
            }
        }
        return null;

    }

    public static ArrayList<Evento> getListaEventosLatLong(LatLng latLong) {
        ArrayList<Evento> list = new ArrayList<>();


        for (Evento lisEvento : getListaEventos()
                ) {
            String[] latlong = lisEvento.getLocal().split(",");
            double latitude = Double.parseDouble(latlong[0]);
            double longitude = Double.parseDouble(latlong[1]);
            LatLng location = new LatLng(latitude, longitude);

            if (location.equals(latLong)) {
                list.add(lisEvento);
            }
        }
        return list;
    }

    public String getDataString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String data = dateFormat.format(dataEvento);
        return data;
    }

    public String getHoraString() {

        SimpleDateFormat dateFormatHora = new SimpleDateFormat("HH:mm:ss");

        String hora = dateFormatHora.format(dataEvento);
        return hora;
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
