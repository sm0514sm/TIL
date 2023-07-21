fun systemInfo1(): String {
  val numberOfCores = Runtime.getRuntime().availableProcessors()
  return when (numberOfCores) {
    1 -> "1 core"
    in 2..16 -> "multi $numberOfCores"
    else -> "$numberOfCores cores! Good"
  }
}

// 향상된 버전
fun systemInfo2(): String =
    when (val numberOfCores = Runtime.getRuntime().availableProcessors()) {
      1 -> "1 core"
      in 2..16 -> "multi $numberOfCores"
      else -> "$numberOfCores cores! Good"
    }