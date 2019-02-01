val items = List(Cola, Coffee)
val total= items.map(_.price)
total.sum

total




case class Person(name:String, age: Int)

val peeps = List(Person("mac", 41), Person("Bob", 20))

val names = peeps.map(p => p.name)

// after map
peeps

val xs = List(1.0, 2.0, 4.0, 5.0)

xs.sum