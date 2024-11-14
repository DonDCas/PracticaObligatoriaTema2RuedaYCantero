import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PracticaObligatoriaTema2RuedaYCantero {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        // Aqui iniciamos las constantes que usaremos
        // Constantes de eventos
        //Constantes del evento 1: La Criada
        final String NOMBREEVENTO1 = "La Criada";
        final LocalDate FECHAEVENTO1 = LocalDate.of(2024, 11, 20);
        final int PRECIOPLATEAEVENTO1 = 17, PRECIOBUTACAEVENTO1 = 20, PRECIOANFIEVENTO1 = 13;
        //Constantes del evento 2: II Concierto de Otoño
        final String NOMBREEVENTO2 = "II Concierto de Otoño";
        final LocalDate FECHAEVENTO2 = LocalDate.of(2024, 11, 28);
        int PRECIOPLATEAEVENTO2 = 12, PRECIOBUTACAEVENTO2 = 15, PRECIOANFIEVENTO2 = 5;
        // Constantes del evento 3: Concierto de Jazz
        final String NOMBREEVENTO3 = "Concierto de Jazz";
        LocalDate FECHAEVENTO3 = LocalDate.of(2024, 12, 8);
        int PRECIOPLATEAEVENTO3 = 20, PRECIOBUTACAEVENTO3 = 25, PRECIOANFIEVENTO3 = 15;
        // Descuentos aplicables
        final float DESCUENTOEVENTO1 = 0.05f, DESCUENTOEVENTO2 = 0.07f, DESCUENTOEVENTO3 = 0.03f, IVA = 0.1f;
        // Las siguientes constantes son solo de estetica para el programa
        final String BARRAH = "◘►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄►◄◘\n";
        final String RENGLON = "◘                                                                                  ◘\n";

        // Aqui se inician las variables.

        // Variables Boolean para controlar el cierre y apertura de menus
        Boolean venta, descuento = FALSE, cerrarPrograma = FALSE, cicloMenuEvento = FALSE, cicloMenuEntradas = FALSE,
                cicloMenuZona = FALSE, posibleCambio = TRUE;

        // Variables para recoger respuestas de usuario
        String respuestaPrimerMenu, respuesta, respuestaTrasVenta, lugarElegido = "", eventoElegido = "", idEntrada = "",
                NombreEvento = "", tiempoRestante = "", userIntro = "", passIntro = "", user = "Admin", password= "Admin1234";

        char respuestaSN = ' ';
        int respuestaSegundoMenu, respuestaTercerMenu = 0, numEntradas = 0, entradaNumerada = 0, respuestaSegundoMenuConsulta = 0;
        float descuentoEvento = 0, precioEvento = 0, totalEvento = 0;
        int entradasPlateaVendidas = 0, entradasButacaVendidas = 0, entradasAnfiVendidas = 0, diaHoy = 0, diaEvento = 0;
        int precioPlateaElegido = 0, precioButacaElegido = 0, precioAnfiElegido = 0, plateasRestantes = 0, butacasRestantes = 0, anfiteatroRestantes = 0;

        // iniciamos una variable para la fecha
        LocalDate fechaEvento = LocalDate.now();
        LocalDate fechaHoy = LocalDate.now();

        //Variables de cambio
        float cambio = 0, pago = 0, cambioDisponible = 0, auxCambio = 0,
                totalRecadudadoEvento1 = 0, totalRecadudadoEvento2 = 0, totalRecadudadoEvento3 = 0;
        int billete100 = 20, billetes50 = 50, billetes20 = 100, billetes10 = 100, billetes5 = 200,
                monedas2 = 500, monedas1 = 500, monedas50 = 1000, monedas20 = 1000, monedas10 = 1000, monedas05 = 3000,
                monedas02 = 3000, monedas01 = 1001, cont100 = 0, cont50 = 0, cont20 = 0, cont10 = 0, cont5 = 0, cont2 = 0,
                cont1 = 0, cont050 = 0, cont020 = 0, cont010 = 0, cont05 = 0, cont02 = 0, cont01 = 0;
        cambioDisponible = billete100*100+billetes50*50+billetes20*20+billetes10*10+billetes5*5+ monedas2*2+monedas1;
        cambioDisponible += monedas50*0.5 + monedas20 * 0.2 + monedas10 * 0.1 + monedas05 * 0.05 + monedas02 * 0.02 + monedas01 * 0.01;

        //Aqui estan las variables para los eventos
        //Evento 1
        //Variables de Entradas vendidas del evento 1
        int entradasPlateaEvento1 = 0, entradasButacaEvento1 = 0, entradasAnfiEvento1 = 0;
        //Evento 2
        //Variables de Entradas vendidas del evento 2
        int entradasPlateaEvento2 = 0, entradasButacaEvento2 = 0, entradasAnfiEvento2 = 0;
        //Evento 3
        //Variables de Entradas vendidas del evento 3
        int entradasPlateaEvento3 = 0, entradasButacaEvento3 = 0, entradasAnfiEvento3 = 0;
        //Inicio de la aplicación
        do {//Este bucle siempre estará activo salvo que el administrador decida cerrarlo
            System.out.printf(BARRAH +
                    "◘  ____  ____   __  ____  ____   __      __   __    _  _   __   ____  ____  ____   ◘\n" +
                    "◘ (_  _)(  __) / _\\(_  _)(  _ \\ /  \\    / _\\ (  )  / )( \\ / _\\ (  _ \\(  __)(__  )  ◘\n" +
                    "◘   )(   ) _) /    \\ )(   )   /(  O )  /    \\/ (_/\\\\ \\/ //    \\ )   / ) _)  / _/   ◘\n" +
                    "◘  (__) (____)\\_/\\_/(__) (__\\_) \\__/   \\_/\\_/\\____/ \\__/ \\_/\\_/(__\\_)(____)(____)  ◘\n" +
                    "◘                         __   __     __   __ _  ____   __                         ◘\n" +
                    "◘                        / _\\ (  )   /  \\ (  ( \\/ ___) /  \\                        ◘\n" +
                    "◘                       /    \\/ (_/\\(  O )/    /\\___ \\(  O )                       ◘\n" +
                    "◘                       \\_/\\_/\\____/ \\__/ \\_)__)(____/ \\__/                        ◘\n" +
                    BARRAH);
            //Entramos en el menu inicial de la aplicación
            System.out.printf("◘ Bienvenido a la aplicacion de venta de entradas del teatro Alvarez Alonso        ◘\n" +
                    "◘ Elija la acción que desea realizar escribiendo la letra correspondiente:         ◘\n" +
                    RENGLON +
                    "◘ A) Comprar entradas para un evento                                               ◘\n" +
                    "◘ B) Comprobar estado de un evento                                                 ◘\n" +
                    "◘ C) Entrar al modo administrativo                                                 ◘\n" +
                    RENGLON + BARRAH + "\n");
            System.out.print("Escriba la letra correspondiente a la acción que desea realizar: ");
            respuestaPrimerMenu = sc.nextLine().toUpperCase();
            //Dependiendo de la elección el programa actuara según lo decidido en el siguiente Switch
            switch (respuestaPrimerMenu) { //Menu Principal
                case "A": //Venta de Entradas
                    do {
                        venta = FALSE;
                        cicloMenuEvento = TRUE;
                        cicloMenuEntradas = FALSE;
                        System.out.printf(BARRAH + """
                                         
                                         Bienvenido, escoja del que le interesa comprar entradas                         
                                         utilizando el numero correspondiente:                                              
                                         1) %s (%s)                                                        
                                         2) %s (%s)                                            
                                         3) %s (%s)                                                
                                         """,
                                NOMBREEVENTO1, FECHAEVENTO1, NOMBREEVENTO2, FECHAEVENTO2, NOMBREEVENTO3, FECHAEVENTO3);
                        System.out.printf("""
                                 
                                0) Volver al menu anterior
                                                                                      
                                """ + BARRAH);
                        //Empezamos otro bucle que solo terminara si el usuario elige una de las opciones
                        //Aqui elige la zona del teatro en la que se quiere sentar
                        System.out.print("Introduce el numero del evento que le interese: ");
                        respuestaSegundoMenu = Integer.parseInt(sc.nextLine());
                        switch (respuestaSegundoMenu) {
                            case 1://Venta de evento 1
                                fechaEvento = FECHAEVENTO1;
                                entradasPlateaVendidas = entradasPlateaEvento1;
                                entradasButacaVendidas = entradasButacaEvento1;
                                entradasAnfiVendidas = entradasAnfiEvento1;
                                eventoElegido = NOMBREEVENTO1;
                                descuentoEvento = DESCUENTOEVENTO1;
                                precioPlateaElegido = PRECIOPLATEAEVENTO1;
                                precioButacaElegido = PRECIOBUTACAEVENTO1;
                                precioAnfiElegido = PRECIOANFIEVENTO1;
                                cicloMenuEvento = TRUE;
                                break;
                            case 2:
                                fechaEvento = FECHAEVENTO2;
                                entradasPlateaVendidas = entradasPlateaEvento2;
                                entradasButacaVendidas = entradasButacaEvento2;
                                entradasAnfiVendidas = entradasAnfiEvento2;
                                eventoElegido = NOMBREEVENTO2;
                                descuentoEvento = DESCUENTOEVENTO2;
                                precioPlateaElegido = PRECIOPLATEAEVENTO2;
                                precioButacaElegido = PRECIOBUTACAEVENTO2;
                                precioAnfiElegido = PRECIOANFIEVENTO2;
                                cicloMenuEvento = TRUE;
                                break;
                            case 3:
                                fechaEvento = FECHAEVENTO3;
                                entradasPlateaVendidas = entradasPlateaEvento3;
                                entradasButacaVendidas = entradasButacaEvento3;
                                entradasAnfiVendidas = entradasAnfiEvento3;
                                eventoElegido = NOMBREEVENTO3;
                                descuentoEvento = DESCUENTOEVENTO3;
                                precioPlateaElegido = PRECIOPLATEAEVENTO3;
                                precioButacaElegido = PRECIOBUTACAEVENTO3;
                                precioAnfiElegido = PRECIOANFIEVENTO3;
                                cicloMenuEvento = TRUE;
                                break;
                            case 0: //Volver al menu anterior
                                cicloMenuEntradas = FALSE;
                                cicloMenuEvento = FALSE;
                                break;
                            default: //Error
                                System.out.println("Por favor, escoja una opción de las disponibles");
                                System.out.println("De vuelta al menu principal ");
                                cicloMenuEvento = FALSE;
                                break;
                        }
                        while (cicloMenuEvento) {
                            System.out.printf(BARRAH + "\n" +
                                            " Aqui tiene un poco de información del evento escogido:                           \n" +
                                            " La fecha de este evento sera el %s                                       \n" +
                                            " El descuento por la compra anticipada(7 dias antes) es de %2.0f%%                    \n" +
                                            " A todos estos precios se le aplicara el IVA (10%%)                                \n\n" +
                                            "Las butacas disponibles son:                                                      \n" +
                                            " 1) Platea \t(%2d€):\t\t%3d/140                                                \n" +
                                            " 2) Butacas \t(%2d€):\t\t%3d/200                                                \n" +
                                            " 3) Anfiteatro\t(%2d€):\t\t%3d/200                                                \n\n\n" +
                                            " 0) Volver al menu anterior                                                       \n"
                                            + BARRAH + "\n", (fechaEvento), (descuentoEvento * 100),
                                    precioPlateaElegido, entradasPlateaVendidas, precioButacaElegido, entradasButacaVendidas, precioAnfiElegido, entradasAnfiVendidas);
                            // Empezamos otro bucle que solo se cerrara cuando el usuario haya elegido correctamente la zona en la que sentarse
                            // Tambien puede elegir si volver al menu anterior y elegir otro evento
                            System.out.print("Introduzca el numero relacionado a la zona en la que desea sentarse: ");
                            respuestaTercerMenu = Integer.parseInt(sc.nextLine());
                            fechaHoy = LocalDate.now();
                            if ((respuestaTercerMenu > 0) && (respuestaTercerMenu < 4)) {
                                System.out.print("¿Quiere entrar en modo debug e introducir la fecha a mano? (S/Cualquier letra) ");
                                respuestaSN = sc.nextLine().toUpperCase().charAt(0);
                                //Las siguientes lineas son para prueba de fechas
                                if (respuestaSN == 'S') {
                                    System.out.print("Introduce la fecha de hoy (yyyy-mm-dd): ");
                                    fechaHoy = LocalDate.parse(sc.nextLine());
                                }else fechaHoy = LocalDate.now();
                                System.out.print("¿Cuantas entradas quiere comprar? ");
                                numEntradas = Integer.parseInt(sc.nextLine());

                            }
                            switch (respuestaTercerMenu) {
                                case 1:
                                    if ((numEntradas<1) && (numEntradas > 140 - entradasPlateaVendidas)) {
                                        System.out.println();
                                        System.out.println("No se disponen de tantas entradas libres para " +
                                                "la zona elegida");
                                        System.out.print("¿Desea comprar en otra zona para este evento? (S/N) ");
                                        respuestaSN = sc.nextLine().toUpperCase().charAt(0);
                                        if (respuestaSN == 'S') break;
                                        else if (respuestaSN == 'N') cicloMenuEvento = FALSE;
                                        else {
                                            System.out.println("No ha marcado una respuesta correcta pero lo " +
                                                    "entenderemos como una negativa\n a comprar entradas en " +
                                                    "este evento" +
                                                    "Pulse Enter para continuar...");
                                            sc.nextLine();
                                            cicloMenuEvento = FALSE;
                                            venta=FALSE;
                                        }
                                        break;
                                    } else {
                                        lugarElegido = "Platea";
                                        entradaNumerada = entradasPlateaVendidas + 1;
                                        precioEvento = precioPlateaElegido;
                                        if ((fechaHoy.isBefore(fechaEvento.minusDays(7)))){
                                            totalEvento = (((precioEvento) - (precioEvento * descuentoEvento)  + (((precioEvento) - (precioEvento * descuentoEvento)) * IVA)) * numEntradas);
                                            System.out.printf("El precio a pagar por la cantidad de entradas es: %.2f\n", totalEvento);
                                        } else{
                                            totalEvento = ((precioEvento) + (precioEvento * IVA)) * numEntradas;
                                            System.out.printf("El precio a pagar por la cantidad de entradas es: %.02f\n", totalEvento);
                                        }
                                        do {
                                            System.out.print("¿Cuanto va a pagar? ");
                                            cambio = Float.parseFloat(sc.nextLine());
                                            pago = cambio;
                                            if (cambio < 0)
                                                System.out.println("Ese pago no es acceptable, ingrese uno decente");
                                        } while (cambio < 0);
                                        if (pago < (precioEvento*numEntradas)){
                                            System.out.println("Pago insuficiente Pulse Enter para continuar ...");
                                            sc.nextLine();
                                            venta = FALSE;
                                        }else{
                                            cambio -= (float)(precioEvento*numEntradas);
                                            if(cambioDisponible < cambio){
                                                System.out.println("No tenemos cambio suficiente, lo sentimos Pulse Enter para continuar: ...");
                                                sc.nextLine();
                                                venta = FALSE;
                                            }
                                            else{
                                                venta = TRUE;
                                                entradasPlateaVendidas += numEntradas;
                                            }
                                        }
                                        break;
                                    }
                                case 2:
                                    if (numEntradas > 200 - entradasButacaVendidas) {
                                        System.out.println();
                                        System.out.println("No se disponen de tantas entradas disponibles para " +
                                                "la zona elegida");
                                        System.out.print("¿Desea comprar en otra zona para este evento? (S/N) ");
                                        respuestaSN = sc.nextLine().toUpperCase().charAt(0);
                                        if (respuestaSN == 'S') break;
                                        else if (respuestaSN == 'N') cicloMenuEvento = FALSE;
                                        else {
                                            System.out.println("No ha marcado una respuesta correcta pero lo " +
                                                    "entenderemos como una negativa\n a comprar entradas en " +
                                                    "este evento");
                                            cicloMenuEvento = FALSE;
                                        }
                                        break;
                                    } else {
                                        lugarElegido = "Butaca";
                                        entradaNumerada = entradasButacaVendidas + 1;
                                        precioEvento = precioButacaElegido;
                                        if ((fechaHoy.isBefore(fechaEvento.minusDays(7)))){
                                            totalEvento = (((precioEvento) - (precioEvento * descuentoEvento)  + (((precioEvento) - (precioEvento * descuentoEvento)) * IVA)) * numEntradas);
                                            System.out.printf("El precio a pagar por la cantidad de entradas es: %.2f\n", totalEvento);
                                        } else{
                                            totalEvento = ((precioEvento) + (precioEvento * IVA)) * numEntradas;
                                            System.out.printf("El precio a pagar por la cantidad de entradas es: %.02f\n", totalEvento);
                                        }
                                        do {
                                            System.out.print("¿Cuanto va a pagar? ");
                                            cambio = Float.parseFloat(sc.nextLine());
                                            pago = cambio;
                                            if (cambio < 0)
                                                System.out.println("Ese pago no es acceptable, ingrese uno decente");
                                        } while (cambio < 0);
                                        if (pago < (precioEvento*numEntradas)){
                                            System.out.println("Pago insuficiente Pulse Enter para continuar ...");
                                            sc.nextLine();
                                            venta = FALSE;
                                        }else{
                                            cambio -= (float)(precioEvento*numEntradas);
                                            if(cambioDisponible < cambio){
                                                System.out.println("No tenemos cambio suficiente, lo sentimos Pulse Enter para continuar: ...");
                                                sc.nextLine();
                                                venta = FALSE;
                                            }
                                            else{
                                                venta = TRUE;
                                                entradasButacaVendidas += numEntradas;
                                            }
                                        }
                                        break;
                                    }
                                case 3:
                                    if (numEntradas > 200 - entradasAnfiVendidas) {
                                        System.out.println();
                                        System.out.println("No se disponen de tantas entradas disponibles para " +
                                                "la zona elegida");
                                        System.out.print("¿Desea comprar en otra zona para este evento? (S/N) ");
                                        respuestaSN = sc.nextLine().toUpperCase().charAt(0);
                                        if (respuestaSN == 'S') break;
                                        else if (respuestaSN == 'N'){
                                            cicloMenuEvento = FALSE;
                                            venta = FALSE;
                                        }
                                        else {
                                            System.out.println("No ha marcado una respuesta correcta pero lo " +
                                                    "entenderemos como una negativa\n a comprar entradas en " +
                                                    "este evento");
                                            cicloMenuEvento = FALSE;
                                        }
                                        break;
                                    } else {
                                        lugarElegido = "Anfiteatro";
                                        entradaNumerada = entradasAnfiVendidas + 1;
                                        precioEvento = precioAnfiElegido;
                                        if ((fechaHoy.isBefore(fechaEvento.minusDays(7)))){
                                            totalEvento = (((precioEvento) - (precioEvento * descuentoEvento)  + (((precioEvento) - (precioEvento * descuentoEvento)) * IVA)) * numEntradas);
                                            System.out.printf("El precio a pagar por la cantidad de entradas es: %.2f\n", totalEvento);
                                        } else{
                                            totalEvento = ((precioEvento) + (precioEvento * IVA)) * numEntradas;
                                            System.out.printf("El precio a pagar por la cantidad de entradas es: %.02f\n", totalEvento);
                                        }
                                        do {
                                            System.out.print("¿Cuanto va a pagar? ");
                                            cambio = Float.parseFloat(sc.nextLine());
                                            pago = cambio;
                                            if (cambio < 0)
                                                System.out.println("Ese pago no es acceptable, ingrese uno decente");
                                        } while (cambio < 0);
                                        if (pago < (precioEvento*numEntradas)){
                                            System.out.println("Pago insuficiente Pulse Enter para continuar ...");
                                            sc.nextLine();
                                            venta = FALSE;
                                        }else{
                                            cambio -= (float)(precioEvento*numEntradas);
                                            if(cambioDisponible < cambio){
                                                System.out.println("No tenemos cambio suficiente, lo sentimos Pulse Enter para continuar: ...");
                                                sc.nextLine();
                                                venta = FALSE;
                                            }
                                            else{
                                                venta = TRUE;
                                                entradasAnfiVendidas += numEntradas;
                                            }
                                        }
                                        break;
                                    }
                                case 0:
                                    venta = FALSE;
                                    cicloMenuEvento = FALSE;
                                    cicloMenuEntradas = TRUE;
                                    break;
                                default:
                                    System.out.println("caca");
                                    break;
                            }
                            if (fechaHoy.isBefore(fechaEvento.minusDays(7))) {
                                descuento = TRUE;
                                cambio = (float) pago - totalEvento;
                                auxCambio = cambio;
                                cambioDisponible -= cambio;
                            } else {
                                descuento = FALSE;
                                cambio = pago-totalEvento;
                                auxCambio = cambio;
                                cambioDisponible -=cambio;
                            }
                            if (venta) {

                                do {//Se calcula el cambio del cliente
                                    if ((cambio >= 100) && (billete100 > 0)) {
                                        cambio -= 100;
                                        cont100++;
                                        billete100--;
                                    } else {
                                        if ((cambio >= 50) && (billetes50 > 0)) {
                                            cambio -= 50;
                                            cont50++;
                                            billetes50--;
                                        } else {
                                            if ((cambio >= 20) && (billetes20 > 0)) {
                                                cambio -= 20;
                                                cont20++;
                                                billetes20--;
                                            } else {
                                                if ((cambio >= 10) && (billetes10 > 0)) {
                                                    cambio -= 10;
                                                    cont10++;
                                                    billetes10--;
                                                } else {
                                                    if ((cambio >= 5) && (billetes5 > 0)) {
                                                        cambio -= 5;
                                                        cont5++;
                                                        billetes5--;
                                                    } else {
                                                        if ((cambio >= 2) && (monedas2 > 0)) {
                                                            cambio -= 2;
                                                            cont2++;
                                                            monedas02--;
                                                        } else {
                                                            if ((cambio >= 1) && (monedas1 > 0)) {
                                                                cambio -= 1;
                                                                cont1++;
                                                                monedas01--;
                                                            } else {
                                                                if ((cambio >= 0.50) && (monedas50 > 0)) {
                                                                    cambio -= 0.50;
                                                                    cont050++;
                                                                    monedas50--;
                                                                } else {
                                                                    if ((cambio >= 0.20) && (monedas20 > 0)) {
                                                                        cambio -= 0.20;
                                                                        cont020++;
                                                                        monedas20--;
                                                                    } else {
                                                                        if ((cambio >= 0.10) && (monedas10 > 0)) {
                                                                            cambio -= 0.10;
                                                                            cont010++;
                                                                            monedas10--;
                                                                        } else {
                                                                            if ((cambio >= 0.05) && (monedas05 > 0)) {
                                                                                cambio -= 0.05;
                                                                                cont05++;
                                                                                monedas05--;
                                                                            } else {
                                                                                if ((cambio >= 0.02) && (monedas2 > 0)) {
                                                                                    cambio -= 0.02;
                                                                                    cont02++;
                                                                                    monedas2--;
                                                                                } else {
                                                                                    if ((cambio >= 0.01) && (monedas1 > 0)) {
                                                                                        cambio -= 0.01;
                                                                                        cont01++;
                                                                                        monedas1--;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (cambio < 0.01) cambio = 0;
                                    //Se da el cambio al cliente
                                    if (cambio == 0) {
                                        System.out.print("cambio realizado");
                                        System.out.println();
                                        sc.nextLine();
                                        if (descuento){
                                            System.out.printf("""
                                                       %sAl precio de %1.02f se le realizara un descuento de %.02f %% 
                                                        Se le suma el 10%% del IVA a su precio con descuento
                                                        Siendo su pago de %.02f€ se le efectuara un cambio de %.02f
                                                        La vuelta se le entregara de la sguiente manera: 
                                                        
                                                        """
                                                    , BARRAH, precioEvento, (descuentoEvento * 100), pago, auxCambio);
                                            if(cont100>0) System.out.printf(" Billetes de 100€:\t\t %4d billetes\n", cont100);
                                            if(cont50>0) System.out.printf(" Billetes de 50€:\t\t %4d billetes\n", cont50);
                                            if(cont20>0) System.out.printf(" Billetes de 20€:\t\t %4d billetes\n", cont20);
                                            if(cont10>0) System.out.printf(" Billetes de 10€:\t\t %4d billetes\n", cont10);
                                            if(cont5>0) System.out.printf(" Billetes de 5€:\t\t %4d billetes\n", cont5);
                                            if(cont2>0) System.out.printf(" Monedas de 2€:\t\t\t %4d monedas\n", cont2);
                                            if(cont1>0) System.out.printf(" Monedas de 1€:\t\t\t%4d monedas\n", cont1);
                                            if(cont050>0) System.out.printf(" Monedas de 50 cent:  \t %4d monedas\n", cont050);
                                            if(cont020>0) System.out.printf(" Monedas de 20 cent: \t %4d monedas\n", cont020);
                                            if(cont010>0) System.out.printf(" Monedas de 10 cent:\t %4d monedas\n", cont010);
                                            if(cont05>0) System.out.printf(" Monedas de 5 cent: \t %4d monedas\n", cont05);
                                            if(cont02>0) System.out.printf(" Monedas de 2 cent:  \t %4d monedas\n", cont02);
                                            if(cont01>0) System.out.printf(" Monedas de 1 cent:  \t %4d monedas\n", cont01);
                                            System.out.printf("""
                                                   %s
                                                   """, BARRAH);

                                            System.out.println("Pulsa Enter para continuar ...");
                                            sc.nextLine();
                                        }else {
                                            System.out.printf("""
                                                       %sAl precio de %1.02f no se le realizara descuento por realizar la compra
                                                        fuera del plazo de descuento. 
                                                        Se le suma el 10%% del IVA a su precio base
                                                        Siendo su pago de %.02f€ se le efectuara un cambio de %.02f
                                                        La vuelta se le entregara de la sguiente manera: 
                                                        
                                                        """
                                                    , BARRAH, precioEvento, pago, auxCambio);
                                            if(cont100>0) System.out.printf(" Billetes de 100€:\t\t %4d billetes\n", cont100);
                                            if(cont50>0) System.out.printf(" Billetes de 50€:\t\t %4d billetes\n", cont50);
                                            if(cont20>0) System.out.printf(" Billetes de 20€:\t\t %4d billetes\n", cont20);
                                            if(cont10>0) System.out.printf(" Billetes de 10€:\t\t %4d billetes\n", cont10);
                                            if(cont5>0) System.out.printf(" Billetes de 5€:\t\t %4d billetes\n", cont5);
                                            if(cont2>0) System.out.printf(" Monedas de 2€:\t\t\t %4d monedas\n", cont2);
                                            if(cont1>0) System.out.printf(" Monedas de 1€:\t\t\t%4d monedas\n", cont1);
                                            if(cont050>0) System.out.printf(" Monedas de 50 cent:  \t %4d monedas\n", cont050);
                                            if(cont020>0) System.out.printf(" Monedas de 20 cent: \t %4d monedas\n", cont020);
                                            if(cont010>0) System.out.printf(" Monedas de 10 cent:\t %4d monedas\n", cont010);
                                            if(cont05>0) System.out.printf(" Monedas de 5 cent: \t %4d monedas\n", cont05);
                                            if(cont02>0) System.out.printf(" Monedas de 2 cent:  \t %4d monedas\n", cont02);
                                            if(cont01>0) System.out.printf(" Monedas de 1 cent:  \t %4d monedas\n", cont01);
                                            System.out.printf("""
                                                   %s
                                                   """, BARRAH);

                                            System.out.println("Pulsa Enter para continuar ...");
                                            sc.nextLine();
                                        }



                                    }
                                } while (cambio != 0);
                                cambio = auxCambio;

                            }

                            if (venta == TRUE) {
                                for (int i = 1; i <= numEntradas; i++) {
                                    idEntrada = lugarElegido.charAt(0) + String.valueOf(entradaNumerada) + String.valueOf(fechaEvento.getYear()) + String.valueOf(fechaEvento.getMonthValue()) + String.valueOf(fechaEvento.getDayOfYear());
                                    System.out.printf(BARRAH +
                                            "◘  ____  ____   __  ____  ____   __      __   __    _  _   __   ____  ____  ____   ◘\n" +
                                            "◘ (_  _)(  __) / _\\(_  _)(  _ \\ /  \\    / _\\ (  )  / )( \\ / _\\ (  _ \\(  __)(__  )  ◘\n" +
                                            "◘   )(   ) _) /    \\ )(   )   /(  O )  /    \\/ (_/\\\\ \\/ //    \\ )   / ) _)  / _/   ◘\n" +
                                            "◘  (__) (____)\\_/\\_/(__) (__\\_) \\__/   \\_/\\_/\\____/ \\__/ \\_/\\_/(__\\_)(____)(____)  ◘\n" +
                                            "◘                         __   __     __   __ _  ____   __                         ◘\n" +
                                            "◘                        / _\\ (  )   /  \\ (  ( \\/ ___) /  \\                        ◘\n" +
                                            "◘                       /    \\/ (_/\\(  O )/    /\\___ \\(  O )                       ◘\n" +
                                            "◘                       \\_/\\_/\\____/ \\__/ \\_)__)(____/ \\__/                        ◘\n" +
                                            BARRAH);
                                    System.out.printf(BARRAH + RENGLON + RENGLON);
                                    System.out.printf("◘ ENTRADA NUMERO %3d de %3d \t\t\t\t\t\t\t\t\t\t\t\t\t    ◘\n", i, numEntradas);
                                    System.out.printf("◘ Nombre del espectáculo: %s  \t\t\t\t\t\t\t\t\t\t\t\t◘\n", eventoElegido);
                                    System.out.printf(RENGLON);
                                    System.out.printf("◘ Entrada para el evento del dia: %s\t\t\t\t\t\t\t\t\t\t◘\n", fechaEvento);
                                    System.out.printf("◘ En el Teatro Alvarez Alonso \t\t\t\t\t\t\t\t\t\t\t\t\t\t◘\n" +
                                            "%s%s%s" +
                                            "◘ Lugar elegido: \t%12s\t\t\t\t\t\t\t\t\t\t\t\t\t◘\n" +
                                            "◘ Entrada nº: \t\t%12d \t\t\t\t\t\t\t\t\t\t\t\t\t◘\n" +
                                            "◘ ID Entrada: \t\t%12s \t\t\t\t\t\t\t\t\t\t\t\t\t◘\n" +
                                            "%s%s%s", RENGLON, BARRAH, RENGLON, lugarElegido, entradaNumerada, idEntrada, RENGLON, BARRAH, RENGLON);
                                    if (!descuento) { //No se realiza descuento
                                        System.out.printf("◘ Entrada no anticipada\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t◘\n" +
                                                "◘ Precio de la entrada de:\t\t\t\t\t\t\t\t\t%5.2f €\t\t\t\t\t◘\n" +
                                                "◘ Pago total a realizar:\t\t\t\t\t\t\t\t\t%5.2f €\t\t\t\t\t◘\n" +

                                                "%s%s\n", precioEvento, (precioEvento * numEntradas), RENGLON, BARRAH);
                                    } else { // Se realiza el descuento
                                        System.out.printf("◘ Por su compra anticipada recibira un descuento de: \t\t%5.2f %%\t\t\t\t\t◘\n" +
                                                "◘ Precio de la entrada de: \t\t\t\t\t\t\t\t\t%5.2f €\t\t\t\t\t◘\n" +
                                                "◘ Precio de la entrada con descuento:\t\t\t\t\t\t%5.2f €\t\t\t\t\t◘\n" +
                                                "◘ Pago total a realizar:\t\t\t\t\t\t\t\t\t%5.2f €\t\t\t\t\t◘\n" +
                                                "%s%s\n", (descuentoEvento * 100), precioEvento, (precioEvento -
                                                (precioEvento * descuentoEvento)), ((precioEvento -
                                                (precioEvento * descuentoEvento)) * numEntradas), RENGLON, BARRAH);

                                    }
                                    entradaNumerada++;
                                    System.out.println("Pulsa enter para imprimir la proxima entrada . . .");
                                    sc.nextLine();
                                }
                                if (respuestaSegundoMenu == 1) totalRecadudadoEvento1 += totalEvento;
                                if (respuestaSegundoMenu == 2) totalRecadudadoEvento2 += totalEvento;
                                if (respuestaSegundoMenu == 3) totalRecadudadoEvento3 += totalEvento;

                                System.out.printf(BARRAH +
                                        " Desea realizar otra compra de este evento:\n\n" +

                                        " 1) Quiero comprar más entradas de este evento\n" +
                                        " 2) Quiero elegir otro evento\n" +
                                        " 3) Quiero volver al menu principal\n\n" +
                                        " Elija una opción mediante el numero correspondiente: ");
                                respuestaTrasVenta = sc.nextLine();
                                cont100 = 0; cont50 = 0; cont20 = 0; cont10 = 0; cont5 = 0; cont2 = 0; cont1 = 0; cont050 = 0;
                                cont020 = 0; cont010 = 0; cont05 = 0; cont02 = 0; cont01 = 0;
                                switch (respuestaTrasVenta) {
                                    case "1":
                                        cicloMenuEvento = TRUE;
                                        for (int i = 0; i < 90; i++) {
                                            System.out.println();
                                        }
                                        break;
                                    case "2"://Volver al menu anterior
                                        cicloMenuEvento = FALSE;
                                        cicloMenuEntradas = TRUE;
                                        for (int i = 0; i < 90; i++) {
                                            System.out.println();
                                        }
                                        break;
                                    case "3"://Volver al menu principal
                                        cicloMenuEvento = FALSE;
                                        cicloMenuEntradas = FALSE;
                                        for (int i = 0; i < 90; i++) {
                                            System.out.println();
                                        }
                                        break;
                                    default://Error
                                        System.out.println("Por favor, escoja una opción de las disponibles");
                                        break;
                                }
                            }
                            switch (respuestaSegundoMenu) {
                                case 1:
                                    if (respuestaTercerMenu == 1) entradasPlateaEvento1 = entradasPlateaVendidas;
                                    if (respuestaTercerMenu == 2) entradasButacaEvento1 = entradasButacaVendidas;
                                    if (respuestaTercerMenu == 3) entradasAnfiEvento1 = entradasAnfiVendidas;
                                    break;
                                case 2:
                                    if (respuestaTercerMenu == 1) entradasPlateaEvento2 = entradasPlateaVendidas;
                                    if (respuestaTercerMenu == 2) entradasButacaEvento2 = entradasButacaVendidas;
                                    if (respuestaTercerMenu == 3) entradasAnfiEvento2 = entradasAnfiVendidas;
                                    break;
                                case 3:
                                    if (respuestaTercerMenu == 1) entradasPlateaEvento3 = entradasPlateaVendidas;
                                    if (respuestaTercerMenu == 2) entradasButacaEvento3 = entradasButacaVendidas;
                                    if (respuestaTercerMenu == 3) entradasAnfiEvento3 = entradasAnfiVendidas;
                                    break;
                            }
                        }
                    } while (cicloMenuEntradas);
                    break;
                case "B":
                    do {
                        System.out.printf(BARRAH + """
                                         
                                         Escoja de que evento le interesa consultar entradas                         
                                         utilizando el numero correspondiente:                                              
                                         1) %s (%s)                                                        
                                         2) %s (%s)                                            
                                         3) %s (%s)                                                
                                         """,
                                NOMBREEVENTO1, FECHAEVENTO1, NOMBREEVENTO2, FECHAEVENTO2, NOMBREEVENTO3, FECHAEVENTO3);
                        System.out.printf("""
                                 
                                0) Volver al menu anterior
                                                                                      
                                """ + BARRAH);
                        System.out.print("Introduce el número del evento que le interese: ");
                        respuestaSegundoMenuConsulta = Integer.parseInt(sc.nextLine());

                        switch (respuestaSegundoMenuConsulta) {
                            case 1:
                                NombreEvento = NOMBREEVENTO1;
                                fechaEvento = FECHAEVENTO1;
                                descuentoEvento = DESCUENTOEVENTO1;
                                plateasRestantes = 140 - entradasPlateaEvento1;
                                butacasRestantes = 200 - entradasButacaEvento1;
                                anfiteatroRestantes = 200 - entradasAnfiEvento1;
                                break;
                            case 2:
                                NombreEvento = NOMBREEVENTO2;
                                fechaEvento = FECHAEVENTO2;
                                descuentoEvento = DESCUENTOEVENTO2;
                                anfiteatroRestantes = 140 - entradasAnfiEvento2;
                                plateasRestantes = 200 - entradasPlateaEvento2;
                                butacasRestantes = 200 - entradasButacaEvento2;
                                break;
                            case 3:
                                NombreEvento = NOMBREEVENTO3;
                                fechaEvento = FECHAEVENTO3;
                                descuentoEvento = DESCUENTOEVENTO3;
                                plateasRestantes = 140 - entradasPlateaEvento3;
                                butacasRestantes = 200 - entradasButacaEvento3;
                                anfiteatroRestantes = 200 - entradasAnfiEvento3;
                                break;
                            default:
                                System.out.println("El número introducido no es válido, por favor introduzca otro");
                                break;
                        }
                    }while (respuestaSegundoMenuConsulta < 1 || respuestaSegundoMenuConsulta > 3);
                    System.out.print("¿Quiere entrar en modo debug e introducir la fecha a mano? (S/N) ");
                    respuestaSN = sc.nextLine().toUpperCase().charAt(0);
                    //Las siguientes lineas son para prueba de fechas
                    if (respuestaSN == 'S') {
                        System.out.print("Introduce la fecha de hoy (yyyy-mm-dd): ");
                        fechaHoy = LocalDate.parse(sc.nextLine());
                    } else fechaHoy = LocalDate.now();
                    diaHoy = fechaHoy.getDayOfYear();
                    diaEvento = fechaEvento.getDayOfYear();
                    if (diaEvento - diaHoy < 0){
                        tiempoRestante = "Ya ha sido este evento...";
                    }else if (diaEvento - diaHoy == 0){
                        tiempoRestante = "Es hoy!";
                    }else if (diaEvento - diaHoy > 0) tiempoRestante = "El evento será en " + String.valueOf(diaEvento - diaHoy) + " días.";
                    System.out.printf(BARRAH + """
                                    \t\t\t\t\tInformación del evento "%s"
                                    Fecha del Evento: %s
                                    Tiempo restante para el evento: %s
                                    Cantidad de asientos restantes: 
                                    Plateas:\t %3s/140
                                    Butacas:\t %3s/200
                                    Anfiteatro:\t %3s/200
                                    """,
                            NombreEvento, fechaEvento, tiempoRestante, plateasRestantes, butacasRestantes, anfiteatroRestantes);
                    if (diaEvento - diaHoy < 7 && diaEvento - diaHoy >= 0) System.out.println("No recibirás el descuento de un " + descuentoEvento * 100);
                    System.out.println("Pulsa ENTER para continuar");
                    sc.nextLine();
                    System.out.print("""
                            Elige que deseas hacer ahora
                            1) Volver al menú de consulta de eventos
                            2) Volver al menú principal
                            """);
                    break;
                case "C": // Modo administrador
                    boolean acceso = FALSE, bucleMenuAdmin = TRUE;
                    String respuestaMenuAdmin = "";
                    int seleccionEvento = 0;
                    do{
                        System.out.print("Introduce el usuario de Administrador: ");
                        userIntro = sc.nextLine();
                        System.out.print("Introduzca contraseña del administrador: ");
                        passIntro = sc.nextLine();
                        if (user.equals(userIntro) && password.equals(passIntro)){
                            System.out.println("Bienvenido Administrador");
                            acceso = TRUE;
                        }else System.out.println("contraseña incorrecta");
                    }while (!acceso);
                    for (int i = 0; i < 90; i++) {
                        System.out.println();
                    }
                    do {//Este bucle se cerrara cuando
                        System.out.print(BARRAH);
                        //Entramos en el menu inicial de la aplicación
                        System.out.printf("◘ Bienvenido a la aplicacion de venta de entradas del teatro Alvarez Alonso        ◘\n" +
                                "◘ Elija la acción que desea realizar escribiendo la letra correspondiente:         ◘\n" +
                                RENGLON +
                                "◘ A) Consultar los ingresos totales por evento                                     ◘\n" +
                                "◘ B) Consultar las monedas restantes del cambio                                    ◘\n" +
                                "◘ C) Cambiar USUARIO y CONTRASEÑA                                                  ◘\n" +
                                "◘ D) Cerrar programa                                                               ◘\n" +
                                RENGLON +
                                "◘ Z) Salir del modo administrador                                                  ◘\n" +
                                BARRAH + "\n");
                        System.out.print("Escriba la letra correspondiente a la acción que desea realizar: ");
                        respuestaMenuAdmin = sc.nextLine().toUpperCase();
                        switch (respuestaMenuAdmin){
                            case "A":
                                do {
                                    System.out.printf(BARRAH + """
                                         
                                         Escoja de que evento le interesa consultar                         
                                         la recaudación correspondiente:                                              
                                         1) %s (%s)                                                        
                                         2) %s (%s)                                            
                                         3) %s (%s)                                                
                                         """,
                                            NOMBREEVENTO1, FECHAEVENTO1, NOMBREEVENTO2, FECHAEVENTO2, NOMBREEVENTO3, FECHAEVENTO3);
                                    System.out.printf("""
                                           
                                        0) Volver al menu anterior
                                                                                              
                                        """ + BARRAH);
                                    System.out.print("Introduce el número del evento que le interese: ");
                                    seleccionEvento = Integer.parseInt(sc.nextLine());

                                    switch (seleccionEvento) {
                                        case 1:
                                            eventoElegido = NOMBREEVENTO1;
                                            fechaEvento = FECHAEVENTO1;
                                            totalEvento = totalRecadudadoEvento1;
                                            break;
                                        case 2:
                                            eventoElegido = NOMBREEVENTO2;
                                            fechaEvento = FECHAEVENTO2;
                                            totalEvento = totalRecadudadoEvento2;
                                            break;
                                        case 3:
                                            eventoElegido = NOMBREEVENTO3;
                                            fechaEvento = FECHAEVENTO3;
                                            totalEvento = totalRecadudadoEvento3;
                                            break;
                                        default:
                                            System.out.println("El número introducido no es válido, por favor introduzca otro");
                                            break;
                                    }
                                    System.out.printf("""
                                            %s
                                            
                                            El evento %s con fecha el dia: %s
                                            lleva recaudado un sumatorio de %6.2f
                                                                                                                                  
                                            %s
                                            """, BARRAH, eventoElegido, fechaEvento, totalEvento, BARRAH);

                                }while (seleccionEvento != 0);
                                break;
                            case "B":
                                System.out.printf("""
                                        %s%s
                                        A Continuación se diran las monedas que 
                                        quedan y el cambio total\n
                                        
                                        Billetes de 100e:\t\t%5d
                                        Billetes de 50e:\t\t%5d
                                        Billetes de 20e:\t\t%5d
                                        Billetes de 10e:\t\t%5d
                                        Billetes de 5e:\t\t\t%5d
                                        Monedas de 2e:\t\t\t%5d
                                        Monedas de 1e:\t\t\t%5d
                                        Monedas de 50cent:\t\t%5d
                                        Monedas de 20cent:\t\t%5d
                                        Monedas de 10cent:\t\t%5d
                                        Monedas de 5cent:\t\t%5d
                                        Monedas de 2cent:\t\t%5d
                                        Monedas de 1cent:\t\t%5d
                                        
                                        Total de cambio:....... %8.2f
                                        %s%s
                                        
                                        Pulse Enter para continuar ...                               
                                        """,BARRAH,RENGLON, billete100,billetes50,billetes20,billetes10,billetes5,
                                        monedas2,monedas1,monedas50,monedas20,monedas10,monedas05,monedas02,monedas1, cambioDisponible,RENGLON,BARRAH);
                                sc.nextLine();
                                break;
                            case "C":
                                System.out.println("Introduzca el nuevo nombre de usuario");
                                user = sc.nextLine();
                                System.out.println();
                                System.out.println("Introduzca la nueva PASSWORD");
                                password = sc.nextLine();
                                break;
                            case "D":
                                System.out.print("Cerrando el programa");
                                Thread.sleep(500);
                                System.out.print(".");
                                Thread.sleep(500);
                                System.out.print(".");
                                Thread.sleep(500);
                                System.out.print(".");
                                bucleMenuAdmin = FALSE;
                                cerrarPrograma = TRUE;
                                break;
                            case "Z":
                                bucleMenuAdmin = FALSE;
                                System.out.println("Adios administrador.");
                                sc.nextLine();
                                for (int i = 0; i < 90; i++) {
                                    System.out.println();
                                }
                                break;
                        }
                    } while (bucleMenuAdmin);
                    break;
                default: //Error en el menu principal
                    System.out.printf("El carácter introducido no es válido, por favor introduzca otro\n");
            }

        } while (!cerrarPrograma);
    }
}