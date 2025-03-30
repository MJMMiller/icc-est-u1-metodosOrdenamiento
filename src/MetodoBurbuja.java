public class MetodoBurbuja {

    public int[] ordenar(int[] arreglo, boolean isDes, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                contComparaciones++;

                if (conPasos) {
                    System.out.println();
                    System.out.println("Comparacion " + contComparaciones + " : " + arreglo[j] + "    >    " + arreglo[j + 1]);
                }

                boolean huboCambio = false;

                if ((isDes && arreglo[j] < arreglo[j + 1]) || (!isDes && arreglo[j] > arreglo[j + 1])) {

                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    contCambios++;
                    huboCambio = true;

                    if (conPasos) {
                        System.out.println("Cambio " + contCambios + " : " + arreglo[j] + "    >    " + arreglo[j + 1]);
                    }
                }

                if (!huboCambio && conPasos) {
                    System.out.println("Cambio : No hay cambio");
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

    public void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}
