fun greet(name: String, msg: String = "Hi ${name.length}"): String = "$msg $name"
println(greet("Eve"))           // Hello Eve
println(greet("Eve", "Howdy"))  // Howdy Eve