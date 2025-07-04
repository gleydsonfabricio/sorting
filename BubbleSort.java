import java.util.Arrays;

class BubbleSort{
	
	public static void sort(int[] v){
		
		int fim = v.length;

		while(true){			

			boolean troca = false;

			for(int i = 0; i < fim - 1; i++)
				if(v[i] > v[i+1]){
					swap(v, i, i+1);
					troca = true;
				}
			
			if(!troca) return;
			--fim;
		}
	}

	private static void swap(int[] v, int i, int j){
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

    // rodar testes, use:
    // java -ea 
    public static void main(String[] args){
        
        InsertionSort alg = new InsertionSort();
        
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

