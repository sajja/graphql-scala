package com.howtographql.scala.sangria

import com.howtographql.scala.sangria.model.model.{Customer, Link}
import slick.jdbc.H2Profile.api._

class DAO(db: Database) {
  def allLinks = List(Link(1, "2", "3"))

  def customer(id: Int) = Customer(1, "test customer")

  def allCustomers = List(Customer(1, "test customer"), Customer(2, "2nd customer"))
}

