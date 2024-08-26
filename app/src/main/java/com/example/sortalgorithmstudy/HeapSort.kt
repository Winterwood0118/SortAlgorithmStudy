package com.example.sortalgorithmstudy

class HeapSort {
    fun heapSort(arr: Array<Int>) {
        val n = arr.size

        // 최대 힙으로 배열 변환
        for (i in n / 2 - 1 downTo 0) {
            heapify(arr, n, i)
        }

        // 힙에서 요소를 하나씩 꺼내서 정렬
        for (i in n - 1 downTo 0) {
            arr.swap(0, i) // 현재 루트(최댓값)를 배열 끝으로 보냄
            heapify(arr, i, 0) // 줄어든 배열에 대해 힙 구조 유지
        }
    }

    private fun heapify(arr: Array<Int>, n: Int, i: Int) {
        var largest = i
        val left = 2 * i + 1
        val right = 2 * i + 2

        // 왼쪽 자식이 더 크다면 교환
        if (left < n && arr[left] > arr[largest]) {
            largest = left
        }

        // 오른쪽 자식이 더 크다면 교환
        if (right < n && arr[right] > arr[largest]) {
            largest = right
        }

        // 루트가 아닌 경우 교환 후 재귀적으로 힙 구조 유지
        if (largest != i) {
            arr.swap(i, largest)
            heapify(arr, n, largest)
        }
    }

    private fun Array<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}