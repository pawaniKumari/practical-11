def countLetterOccurrences(words:List[String]):Int = {
    val lengths = words.map(_.length())

    lengths.reduce(_ + _)
}

object Main extends App {
    val wordsList = List("Pawani" , "Pushpa", "Dilani")
    val totalLength = countLetterOccurrences(wordsList)
    println(s"Total No.of Letters : $totalLength")
}