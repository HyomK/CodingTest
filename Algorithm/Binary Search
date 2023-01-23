> Binary Search
정렬된 데이터 집합을 이분화하면서 탐색하는 방법

![](https://velog.velcdn.com/images/hyom/post/61cdc2e7-79e4-494e-8c1d-7603a58b869f/image.png)

**⭐️ 모든 원소는 정렬되어야 한다.⭐️**

> - 찾고자 하는 값이 arr[mid]인 경우 mid위치가 찾고자하는 값의 index 위치
- 찾고자 하는 값이 arr[mid]보다 작은 경우 mid 위치보다 왼쪽에 위치한다.
- 찾고자 하는 값이 arr[mid]보다 큰 경우 mid 위치보다 오른쪽에 위치한다.

 이분 탐색은 탐색을 진행할 때마다 탐색 범위를 반으로 줄입니다. 분할 정복(Divide Conquer)알고리즘과 유사한데 이분 탐색은 분할 정복 알고리즘의 한 예


``` kotlin
fun BinarySearch(findNumber: Int): Int {
    val arr = listOf<Int>(1,3,5,7,9,11,13)
    var s = 0
    var e: Int = arr.size - 1
    var mid: Int
    var returnNumber = 0
    while (s <= e) {
        mid = (s + e) / 2
        if (findNumber == arr.get(mid)) {
            returnNumber = mid
            break
        }
        else if (findNumber > arr.get(mid)) s = mid + 1
        else if (findNumber < arr.get(mid)) e = mid - 1
    }
    return returnNumber
}
```
- left에서 시작하는 s, right에서 시작하는 e가 서로 교차하게 되면 종료
- (s+e)/2를 이용한 중간 값 mid를 계속 조건에 맞게 변화시키며 탐색범위를 이분
  - 찾지 못하였다면 그냥 종료
  - 찾았다면 idx를 리턴

### 시간 복잡도
n개의 리스트를 매번 2로 나누어 1이 될때까지 비교 연산을 k번 진행한다고 했을 때, k + 1이 결국 최종 시간 복잡도이다. (1이 되었을때도, 비교 연산을 한 번 수행)
> O(logn + 1) = O(logn)


> 이미지 출처: https://velog.io/@alsgk721/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-6-%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89
