object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  List(1,2,3).slice(0,1) ++ List(1,2,3).slice(2,3)//> res0: List[Int] = List(1, 3)
  
  def printlnAll(l: List[Int], k: Int): Unit = {

    if (l.length == k) {
      println(l)
    } else {
      for (i <- 0 to l.length - 1) {
        if (l(i) > 1) {
          printlnAll(List(i - 1, i - 1) ++ l.slice(0, i) ++ l.slice(i + 1, l.length), k)
        }
      }
    }
  }                                               //> printlnAll: (l: List[Int], k: Int)Unit
  printlnAll(List(4, 3, 1), 3)                    //> List(4, 3, 1)
}