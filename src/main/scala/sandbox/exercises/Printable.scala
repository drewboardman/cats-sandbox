package sandbox.exercises

trait Printable[A] {
  def toS(x: A): String
}

object Printable {
  def format[A](x: A)(implicit printable: Printable[A]): String = printable.toS(x)

  def print[A](x: A)(implicit printable: Printable[A]): Unit = println(format(x))
}

object PrintableInstances {
  implicit val PrintableString: Printable[String] = new Printable[String] {
    def toS(str: String): String = str
  }

  implicit val PrintableInt: Printable[Int] = new Printable[Int] {
    def toS(int: Int): String = int.toString
  }

  implicit val PrintableCate: Printable[Cat] = new Printable[Cat] {
    override def toS(x: Cat): String =
      s"${x.name} is a ${x.age.toString} year-old ${x.color} cat."
  }
}

final case class Cat(name: String, age: Int, color: String)
