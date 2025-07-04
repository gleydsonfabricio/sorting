import java.util.Arrays;

public class CountingSort{
   
    public void sort(int[] v){

        if (v.length <= 1) return;
        
        int top = max(v);
        int step = -min(v);

        int[] count = new int[top + step + 1];

        for (int i: v)
            count[i+step] += 1;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        int[] out = new int[v.length];
        for (int i = v.length - 1; i >= 0; i--)
            out[ --count[v[i]+step] ] = v[i];

        for (int i = 0; i<v.length; i++)
            v[i] = out[i];

    }

    public int max(int[] v){
        int iM = 0;
        for (int i = 0; i < v.length; i++)
            if (v[i] > v[iM]) iM = i;

        return v[iM];

    }

    public int min(int[] v){
        int iM = 0;
        for (int i = 0; i < v.length; i++)
            if (v[i] < v[iM]) iM = i;

        return v[iM];
    }

     // rodar testes, use:
    // java -ea 
    public static void main(String[] args){
        
        CountingSort alg = new CountingSort();
        
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