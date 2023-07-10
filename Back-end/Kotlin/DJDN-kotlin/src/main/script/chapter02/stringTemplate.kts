val price = 12.25
val taxRate = 0.05
val output = "the amount $price after tax comes to $${price * (1 + taxRate)}"
val disclaimer = "the amount is in US$, tha's right in \$only"
println(output)
println(disclaimer)