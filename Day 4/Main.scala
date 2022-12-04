import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("input.txt")
    val array = source.getLines.toArray
    println(array.map(x => overlap(split(x, 0), split(x, 1))).sum)
    source.close()
  }


  def split(input: String, n: Int): Range = {
    val split = input.split(",")(n)
    val start = split.split("-")(0)
    val end = split.split("-")(1)
    val range = start.toInt to end.toInt
    return range
  }

  def subsetOf(range1: Range, range2: Range): Int = {
    if (range1.start >= range2.start && range1.end <= range2.end ||
      range2.start >= range1.start && range2.end <= range1.end) 1
    else 0
  }

  def overlap(range1: Range, range2: Range): Int = {
    if ((subsetOf(range1, range2) == 1 ||
      range1.end >= range2.start && range1.start <= range2.start ||
      range2.end >= range1.start && range2.start <= range1.start
    )) 1
    else 0
  }

}

