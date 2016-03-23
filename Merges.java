import java.lang.System;
import java.lang.Object;
import java.util.Comparator;

public class Merges implements Comparable<Merges>{
	private int element;
	
	public Merges(int x) {
			element = x;
	}
	
	public int compareTo(Merges t) {
		return this.element - t.element;
	}
	
	public String toString() {
		return Integer.toString(element);
	}
	
	public static<T extends Comparable<T>> void IntMergeSort(IntMerges[] a, int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			IntMergeSort(a, p, q);
			IntMergeSort(a, q+1, r);
			IntMerge(a, p, q, r);
		}
	}
	public static<T extends Comparable<T>> void IntMerge(IntMerges[] a, int p, int q, int r) {
		int lsize = q - p + 1;
		int rsize = r - q;
		IntMerges L[] = new IntMerges[lsize + 1];
		IntMerges R[] = new IntMerges[rsize + 1];
		int i=0, j=0;
		
		System.arraycopy(a, p, L, 0, lsize);
		System.arraycopy(a, q+1, R, 0, rsize);
		L[lsize] = new IntMerges(Integer.MAX_VALUE);
		R[rsize] = new IntMerges(Integer.MAX_VALUE);
		
		i = 0;
		j = 0;
		for(int k = p; k <= r ; k++) {
			int cmp = L[i].compareTo(R[j]);
			if(i<lsize && j < rsize) {
				if(cmp <= 0) {
					a[k] = L[i];
					i++;
				}
				else {
					a[k] = R[j];
					j++;
				}
			}
			else if (i < lsize) {
				a[k] = L[i];
				i++;
			}
			else {
				a[k] = R[j];
				j++;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int n = 2000000;
		IntMerges m[] = new IntMerges[n];
		for(int i=n; i > 0; i--) {
			m[n - i] = new IntMerges(i);
		}
		
		final long startTime = System.currentTimeMillis();
		IntMergeSort(m, 0, n-1);
		final long endTime = System.currentTimeMillis();
		System.out.println("time Execuiton:" + (endTime - startTime) + " ms");

	}

}
