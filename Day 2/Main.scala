import scala.io.Source
object Main {
  val WIN = 6
  val DRAW = 3
  val LOSS = 0
  val ROCK = 1
  val PAPER = 2
  val SCISSORS = 3


  def main(args: Array[String]): Unit = {
    val buffer = Source.fromFile("Letters.txt")
    print(calculateScore(buffer.getLines().toArray))
    buffer.close()
  }

  def calculateScore(args: Array[String]): Int = {
    args.map(x => {pointsGainedTwo(x.charAt(0), x.charAt(2))}).sum
  }

  def pointsGainedOne(opponent: Char, you: Char): Int = {
    opponent match {
      case 'A' =>
        you match {
          case 'X' =>
            Main.ROCK + Main.DRAW
          case 'Y' =>
            Main.PAPER + Main.WIN
          case 'Z' =>
            Main.SCISSORS + Main.LOSS
        }
      case 'B' =>
        you match {
          case 'X' =>
            Main.ROCK + Main.LOSS
          case 'Y' =>
            Main.PAPER + Main.DRAW
          case 'Z' =>
            Main.SCISSORS + Main.WIN
        }
      case 'C' =>
        you match {
          case 'X' =>
            Main.ROCK + Main.WIN
          case 'Y' =>
            Main.PAPER + Main.LOSS
          case 'Z' =>
            Main.SCISSORS + Main.DRAW
        }
    }
  }

  def pointsGainedTwo(opponent: Char, you: Char): Int = {
    opponent match {
      //ROCK
      case 'A' =>
        you match {
          case 'X' =>
            Main.SCISSORS + Main.LOSS
          case 'Y' =>
            Main.ROCK + Main.DRAW
          case 'Z' =>
            Main.PAPER + Main.WIN
        }

      //PAPER
      case 'B' =>
        you match {
          case 'X' =>
            Main.ROCK + Main.LOSS
          case 'Y' =>
            Main.PAPER + Main.DRAW
          case 'Z' =>
            Main.SCISSORS + Main.WIN
        }

      //SCISSORS
      case 'C' =>
        you match {
          case 'X' =>
            Main.PAPER + Main.LOSS
          case 'Y' =>
            Main.SCISSORS + Main.DRAW
          case 'Z' =>
            Main.ROCK + Main.WIN
        }
    }
  }
}