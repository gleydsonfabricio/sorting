import java.util.Arrays;

public class MergeSort{

    public void sort(int[] v){
        sort(v, 0, v.length-1);
    }

    private void sort(int[] v, int ini, int fim){

        if (ini>=fim) return;

        int mid = (ini + fim) / 2;

        sort(v, ini, mid);
        sort(v, mid+1, fim);
        merge(v, ini, mid, fim);

    }

    private void merge(int[] v, int ini, int mid, int fim){
    
        int[] aux = new int[v.length];

        for (int i = ini; i <= fim; i++)
            aux[i] = v[i];

        int i = ini, j = mid + 1, k = ini;

        while (i <= mid && j <= fim)
            v[k++] = aux[i] <= aux[j] ? aux[i++] : aux[j++];

        while (i<=mid)
            v[k++] = aux[i++];

    }


    // rodar testes, use:
    // java -ea 
    public static void main(String[] args){
        
        MergeSort alg = new MergeSort();
        
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