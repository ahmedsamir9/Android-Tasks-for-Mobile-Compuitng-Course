package com.example.androidtasks.model;

public class Coins {
    private float numberOfCoins ;

    public Coins() {
    }

    public void setNumberOfCoins(float numberofCoins) {
        this.numberOfCoins = numberofCoins;
    }

    public float getNumberOfCoins() {
        return numberOfCoins;
    }
    public float convertFromEgyptianToUS(){
        return (numberOfCoins / 16 );
    }
    public float convertFromUSToEgyptian(){
        return (numberOfCoins * 16 );
    }
}
