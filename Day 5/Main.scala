import scala.io.Source
import scala.collection.mutable.Stack

object Main {
  var pool = new Array[Stack[Char]](9)

  def main(args: Array[String]): Unit = {
    pool = Array(
      Stack('D', 'T', 'W', 'N', 'L'),
      Stack('H', 'P', 'C'),
      Stack('J', 'M', 'G', 'D', 'N', 'H', 'P', 'W'),
      Stack('L', 'Q', 'T', 'N', 'S', 'W', 'C'),
      Stack('N', 'C', 'H', 'P'),
      Stack('B', 'Q', 'W', 'M', 'D', 'N', 'H', 'T'),
      Stack('L', 'S', 'G', 'J', 'R', 'B', 'M'),
      Stack('T', 'R', 'B', 'V', 'G', 'W', 'N', 'Z'),
      Stack('L', 'P', 'N', 'D', 'G', 'W')
    )

    val source = Source.fromFile("Input.txt")
    val array = source.getLines.toArray
    array.foreach( { x =>
      val parsed = parseString(x)
      updateStacks2(parsed(0), parsed(1), parsed(2))
    })

    pool.foreach(
      x => println(x)
    )

  }

  def parseString(string: String): Array[Int] = {
    val array = string
      .split(" ")
      .filter(x => x.map(y => y.isDigit)
        .reduce((a, b) => a && b))
      .map(x => x.toInt)

    return array
  }

  def updateStacks(num: Int, from: Int, to: Int): Unit = {
    for (i <- 0 to num - 1) {
      val temp = pool(from - 1).pop()
      pool(to - 1).push(temp)
    }
  }

  def updateStacks2(num: Int, from: Int, to: Int): Unit = {
    val temp = new Array[Char](num)
    for (i <- 0 to num - 1) {
      temp(i) = pool(from - 1).pop()
    }
    val rev = temp.reverse
    rev.foreach(x => {
      pool(to - 1).push(x)
    })
  }


}
