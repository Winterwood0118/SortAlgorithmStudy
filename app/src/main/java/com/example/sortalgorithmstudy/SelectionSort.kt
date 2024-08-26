package com.example.sortalgorithmstudy

class SelectionSort {
    fun selectionSort(arr: Array<Int>): Array<Int> {
        for (i in arr.indices) {
            var minIndex = i
            for (j in i + 1 .. arr.lastIndex) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            val temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
        }

        return arr
    }
}