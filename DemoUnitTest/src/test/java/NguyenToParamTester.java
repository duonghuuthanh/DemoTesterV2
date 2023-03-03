
import com.dht.services.NguyenToService;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class NguyenToParamTester {
    @ParameterizedTest
    @ValueSource(ints = {5, 7, 11, 17})
    public void testOddNumber(int n) {
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertTrue(actual);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"4,false", "2,true", "3,true"})
    public void testCsv(int n, boolean expected) {
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/data/data.csv", numLinesToSkip = 1)
    public void testCsvFile(int n, boolean expected) {
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }
    
    @ParameterizedTest
    @MethodSource(value = "ntData")
    public void testMethod(int n, boolean expected) {
        boolean actual = NguyenToService.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }
    
    static Stream<Arguments> ntData() {
        // ...
        return Stream.of(
                Arguments.arguments(2,true),
                Arguments.arguments(7,true),
                Arguments.arguments(6,false)
        );
    }
}
