val sites = mapOf("pragprog" to "https://www.pragprog.com",
		"naver", "https://www.naver.com",)
println(sites.size) // 2
println(sites.containsKey("naver")) // true
println(sites.containsValue("https://www.naver.com")) // true
println(sites.contains("naver")) // true
println("naver" in sites) // true

// get, []
//val pragprogSite: String = sites.get("pragprog") // ERROR
val pragprogSite: String? = sites.get("pragprog") // 동작함!
val pragprogSite2: String? = sites["pragprog"] // 동작함!
val pragprogSite3: String = sites.getOrDefault("pragprog", "default.com") // 동작함!

// + - 연산자
val sitesWithExample = sites + ("example" to "http://example.com")
val withoutNaver = sites - "naver"

// 구조 분해
for (entry in sites) {
  println("${entry.key}: ${entry.value})
}
for ((key, value) in sites) {
  println("${key}: ${value})
}