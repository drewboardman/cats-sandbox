package sandbox.exercises.Typeclasses

import sandbox.utils.Cat


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

  implicit val PrintableCat: Printable[Cat] = new Printable[Cat] {
    override def toS(x: Cat): String =
      s"${x.name} is a ${x.age.toString} year-old ${x.color} cat."
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](val a: A) {
    def format(implicit printable: Printable[A]): String = Printable.format(a)
    def print(implicit printable: Printable[A]): Unit = Printable.print(a)
  }
}
