val airportCode = listOf("LAX", "SFO", "PDX", "SEA")
val temperatures = airportCode.map { code -> code to getTemperatureAtAirport(code) }
fun getTemperatureAtAirport(code: String): String = "${Math.round(Math.random() * 30) + code.count()} C"

for (temp in temperatures) {
  println("Airport: ${temp.first}: Temperature: ${temp.second}")
}
