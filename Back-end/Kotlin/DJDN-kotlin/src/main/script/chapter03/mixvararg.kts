fun greet(msg: String, vararg names: String) {
  println("$msg ${names.joinToString(", ")}")
}
greet("hello", "tom", "jerry", "spike")