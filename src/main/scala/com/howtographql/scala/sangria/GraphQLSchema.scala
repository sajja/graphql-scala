package com.howtographql.scala.sangria

import com.howtographql.scala.sangria.model.model.{Customer, Link}
import sangria.schema.{Field, ListType, ObjectType}
import model._
import sangria.schema._
import sangria.macros.derive._

object GraphQLSchema {

  // 1
  val LinkType = ObjectType[Unit, Link]("Link",
    fields[Unit, Link](
      Field("id", IntType, resolve = _.value.id),
      Field("url", StringType, resolve = _.value.url),
      Field("description", StringType, resolve = _.value.description)
    )
  )

  val CustomerType = ObjectType[Unit, Customer](
    "Customer",
    fields[Unit, Customer](
      Field("id", IntType, resolve = _.value.id),
      Field("description", StringType, resolve = _.value.name)
    )
  )

  // 2
  val QueryType = ObjectType(
    "Query",
    fields[MyContext, Unit](
      Field("allLinks", ListType(LinkType), resolve = c => c.ctx.dao.allLinks),
      Field("allCustomers", ListType(CustomerType), resolve = c => c.ctx.dao.allCustomers)
    )
  )

  // 3
  val SchemaDefinition = Schema(QueryType)
}