package org.kmontano.junit5app.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.kmontano.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


class CuentaTest {
    private Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        this.cuenta = new Cuenta("Kevin", new BigDecimal("1000.25"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Iniciando el metodo");
        testReporter.publishEntry(" ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName() +
                " con las etiquetas " + testInfo.getTags());
    }

    @AfterEach
    void tearDown(){
        System.out.println("Finalizando el metodo de prueba.");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando el test");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("probando atributos de la cuenta corriente!")
    class CuentaTestNombreSaldo {
        @Test
        @DisplayName("probando el nombre")
        void testNombreCuenta(){
            System.out.println(testInfo.getTags());
            String esperado = "Kevin";
            String real = cuenta.getPersona();

            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(esperado, real, () -> "El nombre de la cuenta no es el que se esperaba: Esperado " + esperado +" Obtenido: " + real);
            assertTrue(real.equals("Kevin"));
        }

        @Test
        @DisplayName("probando el saldo, que no se a null, mayor que cero, valor esperado.")
        void testSaldoCuenta(){
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.25, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("testeando referencias que sean iguales con el método equals.")
        void testReferenciaCuenta(){
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.00"));

            assertNotEquals(cuenta, cuenta2);
        }
    }

    @Tag("cuenta")
    @Nested
    class CuentaOperacionesTest {
        @Test
        void testDebitoCuenta(){
            cuenta.debito(new BigDecimal(100));

            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.25", cuenta.getSaldo().toPlainString());
        }

        @Test
        void testCreditoCuenta(){
            cuenta.credito(new BigDecimal(100));

            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.25", cuenta.getSaldo().toPlainString());
        }
    }


    @Tag("cuenta")
    @Tag("error")
    @Test
    void testDineroInsuficienteExceptionCuenta(){
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal("1000.26"));
        });

        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";

        assertEquals(esperado, actual);
    }
    @Test
    void testTransferirDineroCuentas(){
        Cuenta cuenta2 = new Cuenta("Kevin Montano", new BigDecimal("900.00"));

        Banco banco = new Banco("Cuscatlan");
        banco.transferir(cuenta2, cuenta, new BigDecimal("500"));
        assertEquals("400.00", cuenta2.getSaldo().toPlainString());
        assertEquals("1500.25", cuenta.getSaldo().toPlainString());
    }

    @Tag("cuenta")
    @Tag("banco")
    @Test
    //@Disabled
    @DisplayName("probando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas(){
        //fail();
        Cuenta cuenta2 = new Cuenta("Kevin", new BigDecimal("900.00"));

        Banco banco = new Banco("Cuscatlan");
        banco.addCuenta(cuenta);
        banco.addCuenta(cuenta2);

        banco.transferir(cuenta2, cuenta, new BigDecimal("500"));
        assertAll(() -> assertEquals("400.00", cuenta2.getSaldo().toPlainString()),
                () -> assertEquals("1500.25", cuenta.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Cuscatlan", cuenta.getBanco().getNombre()),
                () -> {assertEquals("Kevin", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Kevin"))
                        .findFirst().get().getPersona());
                },
                () -> {
                    assertTrue(banco.getCuentas().stream()
                            .anyMatch(c -> c.getPersona().equals("Kevin"))
                    );
                }
        );
    }

    @Nested
    class SistemaOperaticoTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows(){

        }

        @Test
        @EnabledOnOs(OS.LINUX)
        void testSoloLinux(){

        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testNoWindows(){

        }
    }

    @Nested
    class JavaVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void testSoloJdk8(){

        }

        @Test
        @EnabledOnJre(JRE.JAVA_15)
        void testSoloJDK15(){

        }

        @Test
        @DisabledOnJre(JRE.JAVA_15)
        void testNoJDK15(){

        }
    }

    @Nested
    class SystemPropertiesTest{
        @Test
        void imprimirSystemProperties(){
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "15.0.1")
        void testJavaVersion(){

        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev(){

        }
    }

    @Nested
    class VariableAmbienteTest {
        @Test
        void imprimirVariablesAmbiente(){
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k,v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-15.0.1.*")
        void testJavaHome(){

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadores(){

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
        void testEnv(){

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "prod")
        void testEnvProdDisabled(){

        }
    }

    // pruebas con servidores
    @Test
    @DisplayName("test Saldo cuenta Dev")
    void testSaldoCuentaDev(){
        boolean isDev = "dev".equals(System.getProperty("ENV"));

        assumeTrue(isDev); // si es true se ejecuta el resto

        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.25, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("test Saldo cuenta Dev")
    void testSaldoCuentaDev2(){
        boolean isDev = "dev".equals(System.getProperty("ENV"));

        assumingThat(isDev, () -> {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.25, cuenta.getSaldo().doubleValue());
        }); // si es true se ejecuta lo que esta dentro

        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }


    @DisplayName("Probando Devito cuenta Repetir!")
    @RepeatedTest(value = 5, name = "{displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info){
        if (info.getCurrentRepetition() == 3){
            System.out.println("estamos en la repeticion " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.25", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadas {
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "1000"})
        void testDebitoCuenta(String monto){
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,1000"})
        void testDebitoCuentaCsvSource(String index, String monto){
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100", "250,200", "300,300", "510,500", "1000,1000"})
        void testDebitoCuentaCsvSource2(String saldo, String monto){
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto){
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

    }

    @Tag("param")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto){
        cuenta.debito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList(){
        return Arrays.asList("100", "200", "400", "1000");
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeout{

        @Test
        @Timeout(1)
        void testTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 1500, unit = TimeUnit.MICROSECONDS)
        void testTimeout2() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        void testTimeoutAssetions(){
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.MICROSECONDS.sleep(4000);
            });
        }
    }
}