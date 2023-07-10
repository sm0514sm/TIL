fun createMemoFor1(name: String): String {
  if (name == "Eve") {
    val memo = """Dear $name, ㅇㅓ쩌구저쩌구
      |partyt43pogjewpogjwepofjqwpodjqwdqw
      |ofpwejipfoqwjpfoqwjpfdoqwjdpoqwjdpowq | please pan ot
    """.trimMargin()
    return memo
  }
  return ""
}

fun createMemoFor2(name: String): String {
  if (name == "Eve") {
    val memo = """Dear $name, ㅇㅓ쩌구저쩌구
      partyt43pogjewpogjwepofjqwpodjqwdqw
      ofpwejipfoqwjpfoqwjpfdoqwjdpoqwjdpowq | please pan ot
    """.trimMargin()
    return memo
  }
  return ""
}

println(createMemoFor1("Eve"))
println("------------------------------")
println(createMemoFor2("Eve"))