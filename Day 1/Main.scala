import scala.io.Source
import scala.util.control.Breaks._

object Main {
  def main(args: Array[String]): Unit = {
    val buffer = Source.fromFile("Numbers.txt")
    val array = findTopThree(buffer.getLines.toArray)
    var sum = 0
    for (item <- array) {
      sum += item
    }
    print(sum)
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
        temp += line.toInt
      }
    }
    return max
  }

  def findTopThree(lines: Array[String]): List[Int] = {
    var max1 = 0
    var max2 = 0
    var max3 = 0
    var temp = 0

    for (line <- lines) {
      if (line.isBlank) {
        if (temp > max1) {
          val copy = max2
          max3 = copy
          max2 = max1
          max1 = temp
        } else if (temp > max2) {
          val copy = max2
          max3 = max2
          max2 = temp
        } else if (temp > max3) {
          max3 = temp
        }
        temp = 0
      }
      else {
        temp += line.toInt
      }
    }
    return List(max1, max2, max3)
  }
}