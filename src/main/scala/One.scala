import processing.core._

import scala.util.Random

object One extends PApplet {

  private var one:One = _

  def main(args: Array[String]){
    one = new One
    val frame = new javax.swing.JFrame("Test")
    frame.getContentPane().add(one)
    one.init
    frame.pack
    frame.setVisible(true)
  }

}

class One extends PApplet {

  override def setup() = {
    size(800, 800)
    background(0)
  }

  def paintTriangles() = {

    noStroke()
    noFill()

    def coords(from:Int, to:Int, spacing: Int): List[Int] = {
      for (i <- List.range(from, to) if i % spacing == 0) yield i
    }

    val weights = List.tabulate(3)(n => Math.max(0.1, Random.nextDouble()))

    val triangleSize = 32

    coords(-triangleSize, width+triangleSize, triangleSize).foreach(
      x => coords(-triangleSize, height+triangleSize, triangleSize).foreach(
        y => {
          val colors = weights.map(weight => Random.nextInt((weight*255).toInt))
          fill(colors(0), colors(1), colors(2))
          quad(x, y, x + triangleSize, y, x + triangleSize+triangleSize/2, y + triangleSize, x + triangleSize/2, y + triangleSize)
        }
      )
    )

  }

  override def draw() = {

    paintTriangles()
    noLoop()

  }

  override def mouseClicked() = {
    redraw()
  }

}
