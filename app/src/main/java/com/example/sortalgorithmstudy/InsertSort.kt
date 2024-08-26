package com.example.sortalgorithmstudy

class InsertSort {
    fun insertionSort(arr: Array<Int>): Array<Int> {
        for (i in 1 until arr.size) { // 첫 원소 제외
            val key = arr[i]
            var j = i - 1

            while (j >= 0 && arr[j] > key) { // key보다 큰 요소들을 한 칸씩 오른쪽으로 이동
                arr[j + 1] = arr[j]
                j -= 1
            }
            arr[j + 1] = key // 빈자리에 선택원소 삽입
        }
        return arr
    }
}