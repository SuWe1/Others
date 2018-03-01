package change;

import java.util.Arrays;

public class QuickSort {

	public static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];
		while (low < high) {
			while (low < high && list[high] >= tmp) {
				high--;
			}
			list[low] = list[high];
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low];
		}
		list[low] = tmp;
		return low;
	}

	public static void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			_quickSort(list, low, middle - 1);
			_quickSort(list, middle + 1, high);
		}
	}

	public static void quickSort(int[] array) {
		_quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array) + " quickSort");
	}

	public static void main(String[] args) {
		int a[] = new int[] { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34,
				15, 35, 25, 53, 51 };
		quickSort(a);
	}
}
