import java.lang.System;
import java.lang.Object;

public class MergesExt extends Merges {
	private int element;
	
	public MergesExt(int n) {
		super(n);
		element = n;
	}
	
	public static<T extends Comparable<? super T>> void MergeSort(T[] a, int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			MergeSort(a, p, q);
			MergeSort(a, q+1, r);
			Merge(a, p, q, r);
		}
	}

	public static<T extends Comparable<? super T>> void Merge(T[] a, int p, int q, int r) {
		int lsize = q - p + 1;
		int rsize = r - q;
		int i, j;
		Object tmp[] = new Object[r-p+1];
		
		i = 0;
		j = 0;
		for(int k = 0; k <= r-p+1; k++) {
			if(i < lsize && j < rsize) {
				int cmp = a[i].compareTo(a[j]);
				if(cmp <= 0) {
					tmp[k] = a[i];
					i++;
				}
				else {
					tmp[k] = a[j];
					j++;
				}
			}
			else if(i < lsize) {
				tmp[k] = a[i];
				i++;
			}
			else if(j < rsize) {
				tmp[k] = a[j];
				j++;
			}
		}
		for (int k = 0; k < tmp.length; k++) {
		    a[k+p] = (T)(tmp[k]);  
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int n = 1500000;
		
		Integer a[] = new Integer[n];
		for(int i=n; i > 0; i--) {
			a[n - i] = i;
		}
		
		final long startTime = System.currentTimeMillis();
		MergeSort(a, 0, n-1);
		final long endTime = System.currentTimeMillis();
		System.out.println("Merge sort execuiton time:" + (endTime - startTime) + " ms");
	}

}
