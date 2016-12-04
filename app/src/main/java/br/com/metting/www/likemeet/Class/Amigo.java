package br.com.metting.www.likemeet.Class;

import java.util.ArrayList;

/**
 * Created by wisti on 03/12/2016.
 */
public class Amigo {
    int id;
    String nome;
    String tel;

    public Amigo(int id, String nome, String tel) {
        this.id = id;
        this.nome = nome;
        this.tel = tel;
    }
    public Amigo(){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }


    public ArrayList<Amigo> getLista() {
        Amigo a2 = new Amigo(1, "Franklin Wistian", "75999843408");
        Amigo a3 = new Amigo(1, "Clevia lima", "75999843408");
        Amigo a4 = new Amigo(1, "Alexandre Andrade", "75999843408");
        Amigo a5 = new Amigo(1, "Elder Sales", "75999843408");
        Amigo a6 = new Amigo(1, "Like a boss", "75999843408");

        ArrayList<Amigo> list = new ArrayList<>();
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        return list;

    }
}

