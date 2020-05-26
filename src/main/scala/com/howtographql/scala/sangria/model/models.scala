package com.howtographql.scala.sangria.model

package object model {

  case class Link(id: Int, url: String, description: String)

  case class Customer(id: Int, name: String)

}
