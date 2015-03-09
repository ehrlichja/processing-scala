import processing.core._

object Two extends PApplet {

  private var two:Two = _

  def main(args: Array[String]){
    two = new Two
    val frame = new javax.swing.JFrame("Two")
    frame.getContentPane().add(two)
    two.init
    frame.pack
    frame.setVisible(true)
  }

}

class Two extends PApplet {

  override def setup() = {
    size(800, 800)
    background(0)
    stroke(255)
    plot(equation)
    paint()
  }

  def equation(x:Double) : Double = math.pow(x, 2) + 2*x

  def equation2(x:Double, y:Double): Double = (x * y)

  def plot(equation: (Double) => Double): Unit = {
    val yValues = -height to height by 1
    val xValues = yValues.map(y => equation(y))

    val pairs = yValues zip xValues

    pairs.foreach(println)

    translate(width/2, height/2)
    pairs.foreach(p => ellipse(p._1, p._2.toInt, 3, 3))

  }

  def paint(): Unit = {
    val allCoords = List.range(0, width) zip List.range(0, height)
    allCoords.foreach(println)
  }

  override def draw() = {

    noLoop()

  }

  override def mouseClicked() = {
    redraw()
  }

}
