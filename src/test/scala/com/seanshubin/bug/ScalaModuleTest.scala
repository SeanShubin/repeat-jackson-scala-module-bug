package com.seanshubin.bug

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.FunSuite

class ScalaModuleTest extends FunSuite {
  test("repeat bug with DefaultScalaModule for jackson") {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    val parsed = mapper.readValue("""{"a":null}""", classOf[AnyRef])
    assert(parsed === Map("a" -> null))
  }
}
