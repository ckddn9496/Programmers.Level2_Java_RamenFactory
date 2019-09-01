# Programmers.Level2_Java_RamenFactory

## 1. 문제설명
0/1 Knapsack과 성격이 비슷한 문제. input으로 라면공장에 재고 stock, 보급이 들어오는 날짜배열 dates, 보급량배열 supplies, 버텨야하는 일자 k가 들어온다. 최소한의 보급 횟수로 1일부터 k-1일까지 하루에 stock 1만을 소비하며 버틸수 있도록 하는 최소 보급횟수를 return하는 문제. 

## 2. 풀이
**PriorityQueue**를 이용. 1일부터 k-1일까지 loop를 돌게하여 보급을 받을 수 있는 날짜가 되면 그 날의 보급량을 우선순위 큐에 담는다. 우선순위 큐는 높은 숫자의 우선순위가 높도록 한다```PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());```. 매 loop마다 재고가 0개가 되면 우선순위 큐에서 하나의 보급량을 poll하며 이 값은 현재까지 보급을 받을 수 있는 날짜중,가장 많은 보급량을 받을 날의 보급량이다(우선순위에 따라). k-1일까지 이를 반복하며 마지막에 우선순위 큐에서 poll을 수행한 횟수가 보급을 받는 최소횟수가 된다.

## 3. 어려웠던 점
Knapsack문제랑 비슷하게 Branch & Bound방식으로 Node클래스를 만들며 접근하려고 했다. 처음에는 dates.length만큼 반복하는 로직을 구현하였는데, 매 Node마다 모든 남은 supplies의 총합과 K를 비교하는 연산과 날짜에 대한 카운트가 비 효율적임을 느꼇다. 그래서 보급날을 기준으로 loop를 도는 대신 1일 간격으로 하루마다 loop를 돌게하는 방식으로 바꾸어 생각해보다 우선순위큐를 이용하여 훨씬 편하게 구현할수 있음을 깨닫게 되었다.
