@JvmInline
value class SSN(val id: String)
fun receiveSSN(ssn: SSN){
  println("Received $ssn")
}

receiveSSN(SSN("950514-111111"))