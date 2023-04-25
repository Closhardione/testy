package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void priceIndexTestResult(){
        assertEquals(2,Product.priceIndex(2010,3));
    }
    @Test
    void priceIndexTestExeption(){
        assertThrows(IndexOutOfBoundsException.class,()->{
           Product.priceIndex(2005,5);
        });
    }
    private static Stream<Arguments> getMonthYearIndexes() {
        return Stream.of(
                Arguments.of(2010,1,0),
                Arguments.of(2010,11, 10),
                Arguments.of(2011,11, 22),
                Arguments.of(2020,5,124)
        );
    }
    @ParameterizedTest
    @MethodSource("getMonthYearIndexes")
    void priceIndexParameterized(int year,int month, int expected){
        assertEquals(expected,Product.priceIndex(year,month));
    }
    @ParameterizedTest
    @CsvFileSource(resources ="/test.csv",numLinesToSkip = 1, delimiter = ';')
    void priceIndexFromCsv(int year,int month, int expected){
        assertEquals(expected,Product.priceIndex(year,month));
    }
    @Test
    void priceIndexMultiple(){
        int expected=0;
        for(int year= 2010;year<=2020;year++){
            for(int month : IntStream.rangeClosed(1,12).toArray()){
                assertEquals(expected,Product.priceIndex(year,month));
                expected++;
            }
        }
    }
}