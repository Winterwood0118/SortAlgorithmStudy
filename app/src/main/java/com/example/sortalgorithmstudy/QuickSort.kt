package com.example.sortalgorithmstudy

class QuickSort {
    fun quickSort(arr: Array<Int>, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(arr, low, high)

            quickSort(arr, low, pi - 1) // 피벗 기준 왼쪽 부분 정렬
            quickSort(arr, pi + 1, high) // 피벗 기준 오른쪽 부분 정렬
        }
    }

    private fun partition(arr: Array<Int>, low: Int, high: Int): Int {
        val pivot = arr[high] // 마지막 요소를 피벗으로 선택
        var i = low - 1 // 작은 요소의 인덱스

        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                arr.swap(i, j)
            }
        }

        arr.swap(i + 1, high)
        return i + 1
    }

    private fun Array<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}