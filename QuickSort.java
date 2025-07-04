import java.util.Arrays;

public class QuickSort{

    public void sort(int[] v){
        sort(v, 0, v.length-1);
    }

    private void sort(int[] v, int ini, int fim){

        if (ini>=fim) return;

        int pivot = particionaHoare(v, ini, fim);

        sort(v, ini, pivot - 1);
        sort(v, pivot + 1, fim);

    }

    private int particionaLomuto(int[] v, int ini, int fim){

        int pivot = v[ini];

        int i = ini, j = ini + 1;

        while(j <= fim){
            if (v[j] <= pivot)
                swap(v, ++i, j);
            j++;
        }

        swap(v, ini, i);

        return i;

    }

    private int particionaHoare(int[] v, int ini, int fim){

        int pivot = v[ini];

        int i = ini, j = fim;

        while (i<=j){

            while (i<=j && v[i] <= pivot) i++;
            while (i<=j && v[j] > pivot) j--;

            if (i < j) swap(v, i, j);

        }

        swap(v, ini, j);

        return j;

    }

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    // rodar testes, use:
    // java -ea 
    public static void main(String[] args){
        
        QuickSort alg = new QuickSort();
        
        int[] v = new int[]{4, 2, -1, 7};
        alg.sort(v);
        assert Arrays.equals(new int[]{-1, 2, 4, 7}, v);

        v = new int[]{20, 14, 8, 6};
        alg.sort(v);
        assert Arrays.equals(new int[]{6, 8, 14, 20}, v);

        v = new int[]{-6, 7, 9, 10};
        alg.sort(v);
        assert Arrays.equals(new int[]{-6, 7, 9, 10}, v);

        v = new int[]{5, 2, 5, 1, 2};
        alg.sort(v);
        assert Arrays.equals(new int[]{1, 2, 2, 5, 5}, v);

        v = new int[]{};
        alg.sort(v);
        assert Arrays.equals(new int[]{}, v);

        v = new int[]{42};
        alg.sort(v);
        assert Arrays.equals(new int[]{42}, v);
        
    }    

}
