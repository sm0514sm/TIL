// 1~5까지 숫자의 범위 만들기
val oneToFive: IntRange = 1..5

// 알파벳도 가능
val aToE: CharRange = 'a'..'e'

// 문자열도 가능
val seekHelp: ClosedRange<String> = "hell".."help"
println(seekHelp.contains("helm")) // true
println(seekHelp.contains("helq")) // false