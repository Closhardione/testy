package com.company;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {
    @Test
    void fromCsvTest(){
        Path file = Path.of("C:\\Users\\Student\\Desktop\\Aleksadner Stoń\\testy\\src\\test\\resources\\buraki.csv");
        FoodProduct test = FoodProduct.fromCsv(file);
        assertEquals("Buraki - za 1 kg",test.getName());
    }
    @Test
    void fromCsvTest2(){
        Path file = Path.of("C:\\Users\\Student\\Desktop\\Aleksadner Stoń\\testy\\src\\test\\resources\\buraki.csv");
        FoodProduct test = FoodProduct.fromCsv(file);
        assertEquals(1.53,test.getPrice(2010,1,"DOLNOŚLĄSKIE"));
    }

}