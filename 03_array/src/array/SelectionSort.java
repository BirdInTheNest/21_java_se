/*
* 정렬 (Sort)

1. 오름차순(Ascending) 1, 2, 3 ... A, B, C ... ㄱ, ㄴ, ㄷ ...
2. 내림차순(Descending) 

- Selection Sort(선택 정렬)
  선택 정렬은 첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 첫 번째에 놓고, 
  두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여 
  그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행한다.
  1회전을 수행하고 나면 가장 작은 값의 자료가 맨 앞에 오게 되므로 그 다음 회전에서는 두 번째 자료를 가지고 비교한다. 
  마찬가지로 3회전에서는 세 번째 자료를 정렬한다.
  마지막 숫자는 자동으로 정렬되기 때문에 (숫자 개수-1) 만큼 반복한다.

- Bubble Sort (버블 정렬)
  버블 정렬은 첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를,
  이런 식으로 (마지막-1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬한다.
  1회전을 수행하고 나면 가장 큰 자료가 맨 뒤로 이동하므로 2회전에서는 맨 끝에 있는 자료는 정렬에서 제외되고, 
  2회전을 수행하고 나면 끝에서 두 번째 자료까지는 정렬에서 제외된다. 
  이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다.

 */

package array;

public class SelectionSort {

	public static void main(String[] args) {
		int[] ar = {43, 30, 25, 78, 55};
		
		System.out.print("정렬 전 : ");
		for(int x : ar) { //ar주소의 값을 int x에 반복하여 집어넣어 줌
			System.out.print(x+"  ");
		}//for
		System.out.println();
		
		//정렬 - 오름차순
		int temp;
		for(int i=0; i<ar.length-1; i++) { //마지막 숫자는 자동으로 정렬되기 때문에 (숫자 개수-1) 만큼 반복
			for(int j=i+1; j<ar.length; j++) {
				if(ar[i] > ar[j]) { // > 오름차순 < 내림차순
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}//if	
			}//for j
		}//for i
				
		System.out.print("정렬 후 : ");
		for(int x : ar) {
			System.out.print(x+"  ");
		}
		System.out.println();		
	}
}

/*
[실행결과]
정렬 전 : 43  30  25  78  55  
정렬 후 : 25  30  43  55  78 
*/