import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        MetodoBurbuja metodoBurbujaClase = new MetodoBurbuja();
        MetodoSeleccion metodoSeleccionClase = new MetodoSeleccion();
        MetodoInsercion metodoInsercionClase = new MetodoInsercion(); 
        MetodoBurbujaMejorado metodoBurbujaMejoradoClase = new MetodoBurbujaMejorado();         

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            int[] arreglo = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8};

            System.out.println();
            System.out.println("----------------------------------   SELECCIONE EL METODO DE ORDENAMIENTO ---------------------------------");
            System.out.println();
            System.out.println("[ 1 ] Burbuja     [ 2 ] Seleccion         [ 3 ] Insercion         [ 4 ] Burbuja Mejorado      [ 5 ] Salir : ");

            int metodo = getPositive(sc, "Ingrese la opcion: ");

            if (metodo == 5) {
                continuar = false;
                System.out.println();
                System.out.println("-----------------------------------------   GRACIAS POR PARTICIPAR ----------------------------------------");
                break;
            }
            
            boolean conPasos = getValidBoolean(sc, "¿ Desea ver los pasos ?");

            String orden = getValidString(sc, new String[] {"A", "D"},
                "¿ Desea ordenar ? ascendentemente ( A ) o descendentemente ( D ) ");

            boolean ascendente = orden.equalsIgnoreCase("A");
            int contRespuestas[];

            switch (metodo) {
                case 1:
                    System.out.println("Metodo de Burbuja");
                    System.out.print("Arreglo Original: ");
                    metodoBurbujaClase.imprimirArreglo(arreglo);
                    contRespuestas = metodoBurbujaClase.ordenar(arreglo, ascendente, conPasos);
                    System.out.println();
                    System.out.println("--------------------------------------------    FIN DEL METODO  -------------------------------------------");
                    System.out.print("Arreglo Ordenado " + (ascendente ? "Ascendente" : "Descendente") + " : ");
                    metodoBurbujaClase.imprimirArreglo(arreglo);
                    System.out.println("Comparaciones Totales: " + contRespuestas[0] + "\nCambios Totales: " + contRespuestas[1] );
                break;
            
                case 2:
                    System.out.println("Metodo de Seleccion");
                    System.out.print("Arreglo Original: ");
                    metodoSeleccionClase.imprimirArreglo(arreglo);
                    contRespuestas = metodoSeleccionClase.ordenar(arreglo, ascendente, conPasos);
                    System.out.println();
                    System.out.println("--------------------------------------------    FIN DEL METODO  -------------------------------------------");
                    System.out.print("Arreglo Ordenado " + (ascendente ? "Ascendente" : "Descendente") + " : ");
                    metodoSeleccionClase.imprimirArreglo(arreglo);
                    System.out.println("Comparaciones Totales: " + contRespuestas[0] + "\nCambios Totales: " + contRespuestas[1] );
                break;

                case 3:
                    System.out.println("Metodo de Insercion");
                    System.out.print("Arreglo Original: ");
                    metodoInsercionClase.imprimirArreglo(arreglo);
                    contRespuestas = metodoInsercionClase.ordenar(arreglo, ascendente, conPasos);
                    System.out.println();
                    System.out.println("--------------------------------------------    FIN DEL METODO  -------------------------------------------");
                    System.out.print("Arreglo Ordenado " + (ascendente ? "Ascendente" : "Descendente") + " : ");
                    metodoInsercionClase.imprimirArreglo(arreglo);
                    System.out.println("Comparaciones Totales: " + contRespuestas[0] + "\nCambios Totales: " + contRespuestas[1] );
                break;

                case 4:
                    System.out.println("Metodo de Burbuja Mejorado");
                    System.out.print("Arreglo Original: ");
                    metodoBurbujaMejoradoClase.imprimirArreglo(arreglo);
                    contRespuestas = metodoBurbujaMejoradoClase.ordenar(arreglo, ascendente, conPasos);
                    System.out.println();
                    System.out.println("--------------------------------------------    FIN DEL METODO  -------------------------------------------");
                    System.out.print("Arreglo Ordenado " + (ascendente ? "Ascendente" : "Descendente") + " : ");
                    metodoBurbujaMejoradoClase.imprimirArreglo(arreglo);
                    System.out.println("Comparaciones Totales: " + contRespuestas[0] + "\nCambios Totales: " + contRespuestas[1] );
                break;

                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

    public static int getPositive(Scanner scanner, String message){

        int number;

        do{
            System.out.println();
            System.out.print(message + ": ");
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("El numero debe ser positivo. Intente nuevamante");
            }
        }   while   (number <=0);
        return number;
    }

    public static String getValidString(Scanner scanner, String[] posibles, String message){

        String input;
        boolean valido;

        do{
            System.out.print(message + " : ");
            input = scanner.next();
            valido = false;
            for(String posible : posibles){
                if (input.equalsIgnoreCase(posible)) {
                    valido = true;
                    break;
                    
                }
            }
        }   while   (!valido);
        
        return input;
    }

    public static boolean getValidBoolean(Scanner scanner, String message) { 
        String input;
        boolean valido;

        do {
            System.out.print(message + " (  true    /   false   ): ");
            input = scanner.next();
            valido = input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false");
            if (!valido) {
                System.out.println("Opción incorrecta ");
            }
        } while (!valido);

        return Boolean.parseBoolean(input);
    }
}
