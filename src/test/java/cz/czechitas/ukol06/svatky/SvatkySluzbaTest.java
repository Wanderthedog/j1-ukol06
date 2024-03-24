package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {
    @Test
    void vyhledatSvatkyKeDniJednoJmeno() throws IOException {
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        MonthDay den = MonthDay.of(3, 23);
        List<String> svatky = svatkySluzba.vyhledatSvatkyKeDni(den);
        Assertions.assertEquals(1, svatky.size());
        Assertions.assertTrue(svatky.contains("Ivona"));
    }

    @Test
    void vyhledatSvatkyKeDniViceJmen() throws IOException {
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        MonthDay den = MonthDay.of(3, 22);
        List<String> svatky = svatkySluzba.vyhledatSvatkyKeDni(den);
        Assertions.assertEquals(3, svatky.size());
        Assertions.assertTrue(svatky.contains("Lea"));
        Assertions.assertTrue(svatky.contains("Leontina"));
        Assertions.assertTrue(svatky.contains("Leona"));
    }

    @Test
    void vyhledatSvatkyKeDniZadnySvatek() throws IOException {
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        MonthDay denBezSvatku = MonthDay.of(1, 1);
        List<String> svatky = svatkySluzba.vyhledatSvatkyKeDni(denBezSvatku);
        Assertions.assertTrue(svatky.isEmpty());
    }
}

