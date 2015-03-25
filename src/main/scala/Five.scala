import javax.swing.JFrame

import processing.core.PApplet


object Five extends PApplet {

  var five:Five = _

  def main (args: Array[String]): Unit = {
    five = new Five
    val frame = new JFrame("Five")
    frame.getContentPane.add(five)
    five.init()
    frame.pack()
    frame.setVisible(true)
  }

}

class Five extends PApplet {

  var i = 17
  override def setup() = {
    size(1000, 1000)
    background(0)
    fill(255)
    stroke(255)
    strokeWeight(0)
  }

  override def draw() = {
    quad(70, 70, 800, 70, 800, 800, 70, 800)

    stroke(0)
    fill(0)

    translate(100, 70)

    drawSegments((0, 0))

    noLoop()

  }

  def drawSegments(s:(Float, Float)): Unit = {
    val segment = makeSegment(s._1, s._2)
    fill(0, 0, 255 - (i * 13))
    quad(segment._1, segment._2, segment._3, segment._4, segment._5, segment._6, segment._7, segment._8)
    translate(segment._7, segment._8)

    if (i > 1) {
      i -= 1
      drawSegments((segment._1, segment._2))
    }

  }

  def makeSegment(xVal:Float, yVal:Float): (Float, Float, Float, Float, Float, Float, Float, Float) = {
    val offset = i * 10
    ( xVal,    yVal,    xVal+offset, yVal,
      xVal+offset*0.8.toFloat, yVal+30, xVal+offset*0.3.toFloat, yVal+30 )
  }

}
