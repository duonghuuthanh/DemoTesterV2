import com.dht.services.NguyenToService;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class NguyenToTester {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL");
    }
    
    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");
    }
    
    @BeforeEach
    public void beforeEach() {
        System.out.println("BEFORE EACH");
    }
    
    @AfterEach
    public void afterEach() {
        System.out.println("AFTER EACH");
    }
    
    @Test
    @DisplayName("Kiem tra nguyen to chan")
    @Tag("critical")
    public void testEvenNumber() {
        int n = 4;
        boolean expected = false;
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertEquals(expected, actual, "Thuat toan cai sai!!!");
    }
    
    @Test
    @DisplayName("Kiem tra nguyen to le")
    public void testOddNumber() {
        int n = 5;
        boolean expected = true;
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testOddNumber2() {
        int n = 1;
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertFalse(actual);
    }
    
    @Test
    public void testException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            NguyenToService.isNguyenTo(-5);
        });
    }
    
    @Test
    public void testTimeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            NguyenToService.isNguyenTo(113);
        });
    }
}
