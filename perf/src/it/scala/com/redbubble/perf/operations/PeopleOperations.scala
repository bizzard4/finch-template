package com.redbubble.perf.operations

import com.redbubble.finchtemplate.model.people.PersonId
import com.redbubble.perf.common.Graphql._
import com.redbubble.perf.queries.PeopleQueries._
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

trait PeopleOperations {
  final def allPeople(): ChainBuilder = {
    exec(
      graphqlRequest("All People", graphQlQueryBody(allPeopleQuery))
    )
  }

  final def personDetails(personId: PersonId): ChainBuilder = {
    exec(
      graphqlRequest("All People", graphQlQueryBody(personDetailsQuery(personId)))
    )
  }
}
