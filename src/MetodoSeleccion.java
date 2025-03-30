public class MetodoSeleccion {

    public int[] ordenar(int[] arreglo, boolean isDes, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 0; i < n - 1; i++) {
            int indice = i;

            for (int j = i + 1; j < n; j++) {
                contComparaciones++;

                if (conPasos) {
                    System.out.println();
                    System.out.println("Comparacion " + contComparaciones + " : " + arreglo[indice] + " > " + arreglo[j]);
                }

                if (isDes) {
                    if (arreglo[indice] > arreglo[j]) {
                        indice = j;
                    }
                } else {
                    if (arreglo[indice] < arreglo[j]) { 
                        indice = j;
                    }
                }
            }

            if (indice != i) {
                int aux = arreglo[indice];
                arreglo[indice] = arreglo[i];
                arreglo[i] = aux;
                contCambios++;
                if (conPasos) {
                    System.out.println("Cambio " + contCambios + " : " + arreglo[i] + " > " + arreglo[indice]);
                }
            }

            if (conPasos) {
                System.out.print("Estado actual: ");
                imprimirArreglo(arreglo);
            }
        }

        int[] respuesta = {contComparaciones, contCambios};
        return respuesta;
    }

    public void imprimirArreglo(int[] arreglo) {
        for (int i : arreglo) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}