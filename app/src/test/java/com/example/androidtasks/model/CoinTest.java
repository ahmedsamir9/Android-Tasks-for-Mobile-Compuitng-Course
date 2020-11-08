package com.example.androidtasks.model;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CoinTest {
    private Coins coins;
    @Before
    public void setUp(){
        coins = new Coins();
    }
    @Test
    public void convertFromUSToEgyptian() {
        //arrange
        float dollar = 1.0f;
        float actual = 16.0f;
        coins.setNumberOfCoins(dollar);
        //act
        float result = coins.convertFromUSToEgyptian();
        //assert
        assertThat(result).isEqualTo(actual);

    }
    @Test
    public void convertFromEgyptianToUS(){
        //arrange
        float pounds = 16.0f;
        float actual = 1.0f;
        coins.setNumberOfCoins(pounds);
        //act
        float result = coins.convertFromEgyptianToUS();
        //assert
        assertThat(result).isEqualTo(actual);
    }
}
