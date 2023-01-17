> 플로이드워셜 알고리즘 (Floyd-Warshall Algorithm)
모든 정점에 대한 최단 경로를 구하는 방법

최단 경로를 구하는 문제는 크게 4개의 유형이 있다
- 하나의 정점에서 다른 하나의 정점까지의 최단 경로를 구하는 문제
- 하나의 정점에서 다른 모든 정점까지의 최단 경로를 구하는 문제
- 하나의 목적지로가는 모든 최단 경로를 구하는 문제
- 모든 최단 경로를 구하는 문제


### Floyd-Warshall VS Dijkstra & Bellman-Ford

다익스트라와 벨만포드가 두 번째에 해당하는 하나의 정점에서 다른 모든 정점까지의 최단 경로를 구하는 방법으로
모든 정점에 대한 최단 경로를 구하는 플로이드 워셜 알고리즘과는 다르다

다만, 벨만포드 알고리즘과 같이** 음의 가중치가 있어도 가능하다**

플로이드 워셜은 다이나믹 프로그래밍이라는 특징도 있는데
노드의 개수가 N이라고 할때, N번 만큼 단계를 반복하며 점화식에 맞게 2차원 리스트를 갱신하다

**점화식**
` D_ab = min(D_ab, D_ak + D_kb)`




### Flow

- 모든 노드가 다른 모든 노드로 가는 최단 거리 정보를 담아야 하기 때문에
  `2차원 리스트에 ‘최단 거리' 정보를 저장한다`
- 초기 테이블 설정 시, ‘연결되지 않은 간선'에는 INF 값을 넣는다.
- 자기 자신으로 가는 비용은 모두 0으로 초기화한다

<br/>

### 알고리즘

> 시작점 : s, 끝점 : e, 중간점 : k => dist[s][e] = min(dist[s][e], dist[s][k] + dist[k][e])


``` kotlin
       for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(dist[a][b] > c) {
                dist[a][b] = c;
            }
        }
   
   // i:중간점   j:시작점   k:끝점
        for(int i = 1 ; i <= n ; i ++) {
            for(int j = 1 ; j <= n ; j ++) {
                if(dist[j][i] == Integer.MAX_VALUE) continue;
                for(int k = 1 ; k <= n ; k ++) {
                    if(dist[i][k] == Integer.MAX_VALUE) continue;

                    if(dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
```



### 시간복잡도

k, s, e는 3중 for문을 통해 모든 경우의 수를 비교하기 때문에

> 시간복잡도 : O(V^3) (V:노드의 수)
