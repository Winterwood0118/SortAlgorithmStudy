package com.example.sortalgorithmstudy

class RadixSort {
    fun msdRadixSort(array: IntArray) {
        val max = array.maxOrNull() ?: return
        val maxDigits = max.toString().length
        msdRadixSortHelper(array, 0, array.size - 1, maxDigits)
    }

    private fun msdRadixSortHelper(array: IntArray, low: Int, high: Int, digit: Int) {
        if (low >= high || digit <= 0) return

        val buckets = Array(10) { mutableListOf<Int>() }
        val divisor = Math.pow(10.0, (digit - 1).toDouble()).toInt()

        for (i in low..high) {
            val bucketIndex = (array[i] / divisor) % 10
            buckets[bucketIndex].add(array[i])
        }

        var index = low
        for (bucket in buckets) {
            for (num in bucket) {
                array[index++] = num
            }
        }

        var start = low
        for (bucket in buckets) {
            val bucketSize = bucket.size
            if (bucketSize > 0) {
                msdRadixSortHelper(array, start, start + bucketSize - 1, digit - 1)
            }
            start += bucketSize
        }
    }
    fun lsdRadixSort(array: IntArray) {
        // 최대값을 찾아 최대 자릿수를 계산
        val max = array.maxOrNull() ?: return
        var exp = 1  // 자릿수의 위치 (1, 10, 100, ...)

        // Counting Sort를 각 자릿수에 대해 반복
        while (max / exp > 0) {
            countingSortByDigit(array, exp)
            exp *= 10
        }
    }

    private fun countingSortByDigit(array: IntArray, exp: Int) {
        val n = array.size
        val output = IntArray(n)  // 정렬된 배열을 저장하기 위한 임시 배열
        val count = IntArray(10)  // 자릿수별 카운트 배열

        // 현재 자릿수에서 각 숫자의 빈도를 저장
        for (i in array.indices) {
            val digit = (array[i] / exp) % 10
            count[digit]++
        }

        // 누적합을 계산하여 각 숫자의 위치 결정
        for (i in 1 until 10) {
            count[i] += count[i - 1]
        }

        // 카운트 배열을 사용하여 출력 배열에 정렬된 값을 저장
        for (i in array.indices.reversed()) {
            val digit = (array[i] / exp) % 10
            output[count[digit] - 1] = array[i]
            count[digit]--
        }

        // 정렬된 배열을 원본 배열에 복사
        for (i in array.indices) {
            array[i] = output[i]
        }
    }
}