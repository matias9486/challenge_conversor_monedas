import com.alura.conversor_moneda.model.dto.MonedaConversionDTO;
import com.alura.conversor_moneda.model.dto.RegistroConversionDTO;
import com.alura.conversor_moneda.service.ExchangeRateService;
import com.alura.conversor_moneda.model.enums.Moneda;
import com.alura.conversor_moneda.model.exception.ExchangeRateException;
import com.alura.conversor_moneda.service.RegistroConversionService;
import com.alura.conversor_moneda.utils.GestorArchivoRegistros;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion;
        ExchangeRateService cotizacionService = new ExchangeRateService();
        Moneda monedaActual, monedaConversion;

        RegistroConversionDTO registro;
        RegistroConversionService registroService = new RegistroConversionService();

        GestorArchivoRegistros gestorArchivo = new GestorArchivoRegistros();
        registroService.agregarRegistros(gestorArchivo.cargarRegistros());

        while (true) {
            System.out.print("""
                ______________________________________
                💱 Bienvenido al conversor de monedas:
                ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
                1) Dólar -> Peso Argentino
                2) Peso Argentino -> Dólar
                3) Dólar -> Real Brasileño
                4) Real Brasileño -> Dólar
                5) Dólar -> Peso Colombiano
                6) Peso Colombiano -> Dólar
                7) Dólar -> Peso chileno
                8) Peso chileno -> Dólar
                9) Ver registro de conversiones
                10) Salir

                Elija una opción:                 
                """);

            try {
                opcion = Integer.parseInt(lectura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Por favor, ingrese un número válido.");
                continue;
            }

            if (opcion == 10) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            switch (opcion) {
                case 1 -> { monedaActual = Moneda.USD; monedaConversion = Moneda.ARS; }
                case 2 -> { monedaActual = Moneda.ARS; monedaConversion = Moneda.USD; }
                case 3 -> { monedaActual = Moneda.USD; monedaConversion = Moneda.BRL; }
                case 4 -> { monedaActual = Moneda.BRL; monedaConversion = Moneda.USD; }
                case 5 -> { monedaActual = Moneda.USD; monedaConversion = Moneda.COP; }
                case 6 -> { monedaActual = Moneda.COP; monedaConversion = Moneda.USD; }
                case 7 -> { monedaActual = Moneda.USD; monedaConversion = Moneda.CLP; }
                case 8 -> { monedaActual = Moneda.CLP; monedaConversion = Moneda.USD; }
                case 9 -> {
                    if(registroService.obtenerRegistros().isEmpty())
                        System.out.println("No se registraron conversiones aún.");
                    else {
                        System.out.println("\n\uD83D\uDCDD Registro de conversiones:");
                        registroService.obtenerRegistros().forEach(r -> System.out.println("\t" + r));
                    }
                    continue;
                }
                default -> {
                    System.out.println("❌ Por favor, ingrese una opción inválida.");
                    continue;
                }
            }

            try {
                System.out.printf("\n\uD83D\uDCB0\u200B Ingrese el monto en %s a convertir en %s:\n", monedaActual.getDescripcion(), monedaConversion.getDescripcion());
                double montoOriginal = Double.parseDouble(lectura.nextLine());

                if (montoOriginal <= 0) {
                    throw new IllegalArgumentException("El monto debe ser superior a 0");
                }

                MonedaConversionDTO montoConvertido = cotizacionService.obtenerValorMoneda(monedaActual,monedaConversion, montoOriginal);
                System.out.println("""
                        \n✔\uFE0F\u200B Conversión realizada con éxito
                            $%.2f %s(%s) equivale a $%f %s(%s)
                            Valor de conversión: $%f
                        """.formatted(
                                montoConvertido.getMontoOriginal(),
                                montoConvertido.getMonedaActual().getDescripcion() ,
                                montoConvertido.getMonedaActual(),
                                montoConvertido.convertirMonto(),
                                montoConvertido.getMonedaDestino().getDescripcion() ,
                                montoConvertido.getMonedaDestino(),
                                montoConvertido.getValorConversion()
                ));

                //Creación de registro y guardado en colección
                registro = new RegistroConversionDTO(LocalDateTime.now(), montoConvertido);
                registroService.agregarRegistro(registro);

                gestorArchivo.guardarRegistros(registroService.obtenerRegistros());

            } catch (IOException | InterruptedException | NumberFormatException e) {
                System.out.println("\n❌ Se ha producido un error. " + e.getMessage() +"\n");
            } catch (IllegalArgumentException e) {
                System.out.println("\n❌ " + e.getMessage() +"\n");
            } catch (ExchangeRateException e) {
                System.out.println("\n❌ " + e.getMessage() +"\n");
            }
        }

        lectura.close();
    }
}
