package com.example.sortalgorithmstudy

class BubbleSort {
    fun bubbleSort(arr: Array<Int>): Array<Int> {
        var swapped = false
        for (i in arr.indices) {
            swapped = false
            for (j in 0 until arr.lastIndex - i) {
                var temp = 0
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1]
                    arr[j + 1] = arr[j]
                    arr[j] = temp
                    swapped = true
                }
            }
            if (!swapped) break
        }

        return arr
    }
}