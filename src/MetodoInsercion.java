public class MetodoInsercion {

    public int[] ordenar(int[] arreglo, boolean isDes, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 1; i < n; i++) {
            int aux = arreglo[i];
            int j = i - 1;

            if (conPasos) {
                System.out.println();
                System.out.println("Comparacion " + contComparaciones + ": " + arreglo[i] + " > " + arreglo[j]);
            }

            contComparaciones++;

            if (isDes) {
                while (j >= 0 && arreglo[j] > aux) {
                    arreglo[j + 1] = arreglo[j];
                    j--;
                    contCambios++;
                    if (conPasos) {
                        System.out.println("Cambios " + contCambios + ": " + arreglo[j + 1] + " > " + (j >= 0 ? arreglo[j] : "N/A"));
                    }
                }
            } else {
                while (j >= 0 && arreglo[j] < aux) {
                    arreglo[j + 1] = arreglo[j];
                    j--;
                    contCambios++;
                }
            }

            arreglo[j + 1] = aux;

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