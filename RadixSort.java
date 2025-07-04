import java.util.Arrays;

public class RadixSort{

    public void sort(int[] v){

        if (v.length <= 1) return;

        int size = maxDigitsCount(v);

        for (int i = 1; i <= size; i++)
            counting(v, i);

    }

    private void counting(int[] v, int pos){
        
        int[] count = new int[10];

        for (int num: v)
            count[digit(num, pos)] += 1;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        int[] out = new int[v.length];
        for (int i = v.length - 1; i >= 0; i--)
            out[--count[digit(v[i], pos)] ] = v[i];

        for (int i = 0; i<v.length; i++)
            v[i] = out[i];

    }

    private int digit(int num, int pos){
        return (num / (int) Math.pow(10, pos-1)) % 10;
    }

    public int maxDigitsCount(int[] v){
        int size = 0;
        for (int num: v){
            int len = ("" + num).length();
            if (len > size) size = len;
        }
        return size;
    }

    // rodar testes, use:
    // java -ea 
    public static void main(String[] args){
        
        RadixSort alg = new RadixSort();
        
        int[] v = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        alg.sort(v);
        assert Arrays.equals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, v);

        v = new int[]{54321, 12345, 98765, 23456, 87654};
        alg.sort(v);
        assert Arrays.equals(new int[]{12345, 23456, 54321, 87654, 98765}, v);

        v = new int[]{321, 9, 123456, 5000, 1, 78901};
        alg.sort(v);
        assert Arrays.equals(new int[]{1, 9, 321, 5000, 78901, 123456}, v);

        v = new int[]{100, 10, 1, 1000, 10, 100};
        alg.sort(v);
        assert Arrays.equals(new int[]{1, 10, 10, 100, 100, 1000}, v);

        v = new int[]{1, 2, 3, 4, 5};
        alg.sort(v);
        assert Arrays.equals(new int[]{1, 2, 3, 4, 5}, v);

        v = new int[]{9, 8, 7, 6, 5};
        alg.sort(v);
        assert Arrays.equals(new int[]{5, 6, 7, 8, 9}, v);

        v = new int[]{};
        alg.sort(v);
        assert Arrays.equals(new int[]{}, v);

        v = new int[]{42};
        alg.sort(v);
        assert Arrays.equals(new int[]{42}, v);
        
    }    

}