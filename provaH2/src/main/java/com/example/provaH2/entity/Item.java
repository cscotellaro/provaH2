package com.example.provaH2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Arrays;

@Entity
public class Item {

    private static int max=1;
    @Id //@GeneratedValue
    private int id;
    private String indizi[];
    private String parola;

    public Item(){}

    public Item(String parola) {
        this.indizi = new String[4];
        this.parola = parola;
    }

    @PrePersist
    private void settaId(){
        synchronized (Item.class) {
            id = max;
            max++;
        }
    }

    //TODO: Controllo sugli ndici
    public void addIndizio(int i, String indizio){
        indizi[i]=indizio;
    }

    public String getIndizio(int i){
        return indizi[i];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", indizi=" + Arrays.toString(indizi) +
                ", parola='" + parola + '\'' +
                '}';
    }
}