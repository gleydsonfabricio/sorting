import java.util.Arrays;

public class SelectionSort{

    public void sort(int[] v){

        for (int i = 0; i < v.length; i++)
            swap(v, i, indexMin(v, i));
    
    }

    private int indexMin(int[] v, int ini){
    
        int iM = ini;
        for (int i = ini + 1; i < v.length; i++)
            if (v[i] < v[iM]) iM = i;

        return iM;
    }

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    // rodar testes, use:
    // java -ea 
    public static void main(String[] args){
        
        SelectionSort alg = new SelectionSort();
        
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