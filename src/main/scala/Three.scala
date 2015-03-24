import javax.swing.JFrame

import processing.core.PApplet

object Three extends PApplet {

  var three:Three = _

  def main (args: Array[String]) {
    three = new Three
    val frame = new JFrame("Three")
    frame.getContentPane.add(three)
    three.init()
    frame.pack()
    frame.setVisible(true)
  }

}

class Three extends PApplet {

  var r = 3.0
  var r2 = 0.3

  override def setup() = {
    size(500, 500)
    background(12, 65, 78)
    fill(12, 65, 78, 20)
    fill(12, 65, 78)
    stroke(255, 202)
  }

  override def draw() = {
    make(width/2, height/2, r)
    r = r * 1.04
    if ((r/30) >= width*2) r = 3.0
  }

  def make(x:Double, y:Double, r:Double): Unit = {
    for (i <- 1 to 30) ellipse(x.toFloat, y.toFloat, (r/i).toFloat, (r/i).toFloat)
  }

}
