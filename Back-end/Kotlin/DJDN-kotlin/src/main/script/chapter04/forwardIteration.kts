// i는 val이다
for (i in 1..5) { print("$i, ") }  //1, 2, 3, 4, 5
for (ch in 'a'..'e') { print(ch) }

// ClosedRange<T>는 iterator()가 없으므로 오류발생!!
for (word in "hell".."help") { print("$word, ") } // ERROR
//> for-loop range must have an 'iterator()' method