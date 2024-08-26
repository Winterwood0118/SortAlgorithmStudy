package com.example.sortalgorithmstudy

class MergeSort {
    fun mergeSort(arr: Array<Int>): Array<Int> {
        // 배열의 크기가 1 이하라면 이미 정렬된 상태이므로 그대로 반환
        if (arr.size <= 1) {
            return arr
        }

        // 배열을 반으로 나눔
        val middle = arr.size / 2
        val left = arr.sliceArray(0 until middle)
        val right = arr.sliceArray(middle until arr.size)

        // 재귀적으로 두 부분을 정렬
        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()

        // 두 배열을 비교하여 작은 값을 결과 리스트에 추가
        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                result.add(left[i])
                i++
            } else {
                result.add(right[j])
                j++
            }
        }

        // 남은 요소들을 결과 리스트에 추가
        while (i < left.size) {
            result.add(left[i])
            i++
        }

        while (j < right.size) {
            result.add(right[j])
            j++
        }

        return result.toTypedArray()
    }
}