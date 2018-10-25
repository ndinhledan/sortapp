import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SortApp{
	private static Boolean paused = false;
	public static void go() {
		long start;
		long end;
		Scanner sc = new Scanner(System.in);
		int[] ar1;
		int[] ar2;
		int[] ar3;
		System.out.printf("Enter array size: ");
		int size = sc.nextInt();
		if (size == -1){
			paused = true;
			return;
		}
		ar1 = new int[size];
		ar2 = new int[size];
		ar3 = new int[size];

		//System.out.print("Enter limit for merge insert sort: ");
		//int lim = sc.nextInt();

		for (int i =0; i<size; i++){
			ar1[i] = ThreadLocalRandom.current().nextInt(0,size+1);
			ar2[i] = i+1;
			ar3[i] = size-i;
		}
		/////////////////////////////////////////
		//making copy of arrays for experiments
		// 3 of each for 3 experiments
		////////////////////////////////////////
		int [] tmp11 = new int[size];
		System.arraycopy(ar1, 0, tmp11, 0, size);
		int [] tmp12 = new int[size];
		System.arraycopy(ar1, 0, tmp12, 0, size);
		//int [] tmp13 = new int[size];
		//System.arraycopy(ar1, 0, tmp13, 0, size);
		int [] tmp21 = new int[size];
		System.arraycopy(ar2, 0, tmp21, 0, size);
		int [] tmp22 = new int[size];
		System.arraycopy(ar2, 0, tmp22, 0, size);
		//int [] tmp23 = new int[size];
		//System.arraycopy(ar2, 0, tmp23, 0, size);
		int [] tmp31 = new int[size];
		System.arraycopy(ar3, 0, tmp31, 0, size);
		int [] tmp32 = new int[size];
		System.arraycopy(ar3, 0, tmp32, 0, size);
		//int [] tmp33 = new int[size];
		//System.arraycopy(ar3, 0, tmp33, 0, size);


//////////////////////////////////////////////Insertion Sort////////////////////////////////////////////////////

		System.out.println("=================Insertion Sort====================================");

		start = System.nanoTime();
		int insCount1 = insertSort(tmp11, 0, size-1);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for insertion sort of array 1(random): %d\n\n", 
			insCount1);
		System.out.printf("CPU time for insertion sort of array 1(random): %d\n\n", end-start);


		start = System.nanoTime();
		int insCount2 = insertSort(tmp21, 0, size-1);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for insertion sort of array 2(ascending): %d\n\n", 
			insCount2);
		System.out.printf("CPU time for insertion sort of array 2(ascending): %d\n\n", end-start);

		start = System.nanoTime();
		int insCount3 = insertSort(tmp31, 0, size-1);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for insertion sort of array 3(descending): %d\n\n", 
			insCount3);
		System.out.printf("CPU time for insertion sort of array 3(descending): %d\n\n", end-start);


		System.out.println("====================================================================");
		System.out.println();

///////////////////////////////////////////////////////Merge Sort///////////////////////////////////////////////////////////////
		System.out.println("=================Merge Sort====================================");
		start = System.nanoTime();
		int merCount1 = mergeSort(tmp12, 0, size-1);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for merge sort of array 1(random): %d\n\n", 
			merCount1);
		System.out.printf("CPU time for merge sort of array 1(random): %d\n\n", 
			end-start);

		start = System.nanoTime();
		int merCount2 = mergeSort(tmp22, 0, size-1);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for merge sort of array 2(ascending): %d\n\n", 
			merCount2);
		System.out.printf("CPU time for merge sort of array 2(ascending): %d\n\n", 
			end-start);

		start = System.nanoTime();
		int merCount3 = mergeSort(tmp32, 0, size-1);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for merge sort of array 3(descending): %d\n\n", 
			merCount3);
		System.out.printf("CPU time for merge sort of array 3(descending): %d\n\n", 
			end-start);
		System.out.println("==============================================================");
		System.out.println();

//////////////////////////////////////////////////////Merge Insert Sort///////////////////////////////////////////
		/*
		System.out.println("=================Merge Insert Sort====================================");
		printa(tmp13, size);
		start = System.nanoTime();
		int merInCount1 = mergeInsertSort(tmp13, 0, size-1, lim);
		end = System.nanoTime();
		printa(tmp13, size);	
		System.out.printf("Number of comparison(s) for merge insert sort of array 1(random): %d\n\n", 
			merInCount1);
		System.out.printf("CPU time for merge insert sort of array 1(random): %d\n\n", 
			end-start);

		start = System.nanoTime();
		int merInCount2 = mergeInsertSort(tmp23, 0, size-1, lim);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for merge insert sort of array 2(ascending): %d\n\n", 
			merInCount2);
		System.out.printf("CPU time for merge insert sort of array 2(ascending): %d\n\n", 
			end-start);

		start = System.nanoTime();
		int merInCount3 = mergeInsertSort(tmp33, 0, size-1, lim);
		end = System.nanoTime();
		System.out.printf("Number of comparison(s) for merge insert sort of array 3(descending): %d\n\n", 
			merInCount3);
		System.out.printf("CPU time for merge insert sort of array 3(descending): %d\n\n", 
			end-start);
		System.out.println("=======================================================================");
		System.out.println();
		*/
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////Insertion Sort
/////////////////////////////////////////////////////////////////////////////////////////////////

	public static int insertSort(int[] data, int n, int m){
		int count =0;
		for (int i=n; i<=m; i++){
			for (int j=i; j>0; j--){
				if (data[j] < data[j-1]){
					count ++;
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
				else {
					count++;
					break;
				}
			}
		}
		return count;
	}


////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////Merge Sort
/////////////////////////////////////////////////////////////////////////////////////////////////


	public static int mergeSort(int[] data, int n, int m){
		int c1=0;
		int c2=0;
		if (m-n <=0) return 0;
		else if (m-n >1){
			int mid = (int) (n+m)/2;
			c1 = mergeSort(data, n, mid);
			c2 = mergeSort(data, mid+1, m);
		}

		return c1 + c2 + merge(data, n, m);
	}

	public static int merge(int[] data, int n, int m){
		int count =0;
		int mid = (int) (n+m)/2;
		int a = n;
		int b = mid + 1;
		int temp;
		if (m-n <=0) return 0;
		while (a <= mid && b<= m){
			if (data[a] < data[b]){
				a++;
				count ++;
			}
			else if (data[a] > data[b]){
				count ++;
				temp = data[b++];
				for (int i = ++mid; i >a; i--){
					data[i] = data[i-1];
				}
				data[a++] = temp;
			}
			else {
				count ++;
				if (a == mid && b == m) break;
				temp = data[b++];
				a++;
				for (int i = ++mid; i>a; i--){
					data[i] = data[i-1];
				}
				data[a++] = temp;
			}
		}
		return count;
	}

	///////////////////////////////////////////////////////////////////
	//////////mergeInsert
	////////////////////////////////////////////////////////////////////
	public static int mergeInsertSort(int[] data, int n, int m, int s){
		int c1 =0;
		int c2 =0;
		if (m-n >s){
			int mid = (int) (m+n)/2;
			c1 = mergeInsertSort(data, n, mid, s);
			c2 = mergeInsertSort(data, mid+1, m, s);
			return c1 + c2 + merge(data, n, m);
		}
		else {
			return insertSort(data, n, m);
		}
	}

	



	public static void printa(int[] a, int size){
		for (int i=0; i<size; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		while (!paused){
			SortApp.go();
		}
	}
}

