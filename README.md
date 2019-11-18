# DataStructureAndAlgorithm
This project is used for recording some basic and High-level algorithm

Programing Language  JAVA

/**
	 * 堆排序  O(n*logn)
	 *
	 * @param array
	 */
	public static void heapSort(int[] array) {
		//big heap
		int heapSize = array.length;
		for (int i = 0; i < heapSize; i++) {
			int j = i;
			while (array[j] > array[(j - 1) / 2]) {
				int temp = array[j];
				array[j] = array[(j - 1) / 2];
				array[(j - 1) / 2] = temp;
				j = (j - 1) / 2;
			}
		}
		int temp = array[0];
		array[0] = array[heapSize - 1];
		array[heapSize - 1] = temp;
		heapSize--;
		while (heapSize > 0) {
			int j = 0;
			int left = 2 * j + 1;
			while (left < heapSize) {
				int larger = (left + 1) < heapSize && array[left] < array[left + 1] ? left + 1 : left;
				larger = array[j] > array[larger] ? j : larger;
				if (larger == j) {
					break;
				}
				temp = array[j];
				array[j] = array[larger];
				array[larger] = temp;
				j = larger;
				left = 2 * j + 1;
			}
			temp = array[0];
			array[0] = array[heapSize - 1];
			array[heapSize - 1] = temp;
			heapSize--;
		}
	}
