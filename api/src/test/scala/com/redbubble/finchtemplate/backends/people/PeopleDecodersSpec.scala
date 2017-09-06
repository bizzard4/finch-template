package com.redbubble.finchtemplate.backends.people

import com.redbubble.finchtemplate.model.Person
import com.redbubble.finchtemplate.util.spec.FinchTemplateGenerators
import com.redbubble.util.spec.SpecHelper
import org.scalacheck.Prop._
import org.scalacheck.Properties
import org.specs2.mutable.Specification

final class PeopleDecodersSpec extends Specification with SpecHelper with FinchTemplateGenerators with PeopleApiJson {
  val decodingProp = new Properties("People decoding") {
    property("decoding a single person") = forAll(genPerson) { (person: Person) =>
      val json = personJson(person)
      val decoded = decode(json)(PeopleDecoders.personDecoder)
      decoded must beRight(person)
    }

    property("decoding a list of people") = forAll(genPerson) { (person: Person) =>
      val json = peopleJson(Seq(person))
      val decoded = decode(json)(PeopleDecoders.peopleDecoder)
      decoded must beRight(Seq(person))
    }
  }

  s2"Decoding people responses$decodingProp"
}
