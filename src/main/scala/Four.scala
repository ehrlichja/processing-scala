import javax.swing.JFrame

import processing.core.PApplet

object Four extends PApplet {

  var four:Four = _

  def main (args: Array[String]) {
    four = new Four
    val frame = new JFrame("Four")
    frame.getContentPane.add(four)
    four.init()
    frame.pack()
    frame.setVisible(true)
  }
}

class Four extends PApplet {

  override def setup(): Unit = {
    size(600, 500)
    background(200)
    stroke(255)
    strokeWeight(0)
    fill(11, 22, 177)
  }

  override def draw() = {

    for (i <- 1 to 10) {
      for (i <- 1 to 10) {
        make
        translate(60, 0)
      }
      translate(-600, 50)
    }

//    make
//    translate(60, 0)
//    make
//    translate(60, 0)
//    make
//    translate(60, 0)
//    make
//    translate(60, 0)
//    make
//    translate(0, 50)
//    make
//    translate(-60, 0)
//    make
//    translate(-60, 0)
//    make
//    translate(-60, 0)
//    make
//    translate(-60, 0)
//    make
  }

  def make() = {
    beginShape()
    vertex(10, 0)
    vertex(50, 0)
    vertex(60, 10)
    vertex(60, 40)
    vertex(50, 50)
    vertex(10, 50)
    vertex(0, 40)
    vertex(0, 10)
    vertex(10, 0)
    endShape()
  }

}
