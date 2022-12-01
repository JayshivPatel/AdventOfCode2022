import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val buffer = Source.fromFile("Numbers.txt")
    print(findMax(buffer.getLines.toArray))
    buffer.close()
  }

  def findMax(lines: Array[String]) : Int = {
    var max = 0
    var temp = 0
    for (line <- lines) {
      if (line.isBlank) {
        if (max < temp) {
          max = temp
        }
        temp = 0
      } else {
        var toAdd = line.toInt
        temp += toAdd
      }
    }
    return max
  }
}