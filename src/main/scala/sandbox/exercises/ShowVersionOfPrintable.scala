package sandbox.exercises

import cats.Show
import sandbox.utils.Models.Dog

object ShowInstances {
  implicit val dogShow: Show[Dog] =
    Show.show(dog => s"name: ${dog.name}, age: ${dog.age}, color: ${dog.color}.")
}
