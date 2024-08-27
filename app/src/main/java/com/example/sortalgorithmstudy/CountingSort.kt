package com.example.sortalgorithmstudy

class CountingSort {
    fun countingSort(array: IntArray): IntArray {
        // 1. 배열에서 최대값 찾기
        val max = array.maxOrNull() ?: return array

        // 2. 카운트 배열 생성 및 초기화
        val count = IntArray(max + 1)

        // 3. 카운트 배열 채우기
        for (num in array) {
            count[num]++
        }

        // 4. 누적 합 계산
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }

        // 5. 출력 배열 생성 및 정렬된 값 채우기
        val output = IntArray(array.size)
        for (i in array.indices.reversed()) {
            val num = array[i]
            output[count[num] - 1] = num
            count[num]--
        }

        // 6. 결과 배열 반환
        return output
    }
}