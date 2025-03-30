public class MetodoBurbujaMejorado {

    public int[] ordenar(int[] arreglo, boolean isDes, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {
                contComparaciones++;

                if (conPasos) {
                    System.out.println();
                    System.out.println("Comparacion " + contComparaciones + " : " + arreglo[j] + "    >    " + arreglo[j + 1]);
                }


                if (isDes) {

                    if (arreglo[j] > arreglo[j + 1]) {
                        intercambiar(arreglo, j, j + 1);
                        contCambios++;

                        if (conPasos) {
                            System.out.println("Cambio " + contCambios + " : " + arreglo[j] + "    >    " + arreglo[j + 1]);
                        }
                    } else if (conPasos) {
                        System.out.println("Cambio : No hay cambio");
                    }

                } else {

                    if (arreglo[j] < arreglo[j + 1]) {
                        intercambiar(arreglo, j, j + 1);
                        contCambios++;

                        if (conPasos) {
                            System.out.println("Cambio " + contCambios + " : " + arreglo[j] + "    >    " + arreglo[j + 1]);
                        }
                    } else if (conPasos) {
                        System.out.println("Cambio : No hay cambio");
                    }
                }

                if (conPasos) {
                    System.out.print("Estado actual: ");
                    imprimirArreglo(arreglo);
                }
            }
        }

        int[] respuesta = {contComparaciones, contCambios};
        return respuesta;
    }

    private void intercambiar(int[] arreglo, int i, int j) {
        int aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }

    public void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}