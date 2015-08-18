/*
 * Copyright 2015 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.heikoseeberger.reactiveflows

import akka.actor.{ Actor, ActorRef, Props, SupervisorStrategy, Terminated }
import de.heikoseeberger.akkamacrologging.ActorLogging

object ReactiveFlows {

  // $COVERAGE-OFF$
  final val Name = "reactive-flows"

  def props(mediator: ActorRef, replicator: ActorRef): Props = Props(new ReactiveFlows(mediator, replicator))
  // $COVERAGE-ON$
}

class ReactiveFlows(mediator: ActorRef, replicator: ActorRef) extends Actor with ActorLogging with ActorSettings {

  override val supervisorStrategy = SupervisorStrategy.stoppingStrategy

  private val flowFacade = context.watch(createFlowFacade())

  context.watch(createHttpService())
  log.info("Up and running")

  override def receive = {
    case Terminated(actor) => onTerminated(actor)
  }

  protected def createFlowFacade(): ActorRef = context.actorOf(FlowFacade.props(mediator, replicator), FlowFacade.Name)

  // $COVERAGE-OFF$
  protected def createHttpService(): ActorRef = {
    import settings.httpService._
    context.actorOf(
      HttpService.props(interface, port, flowFacade, flowFacadeTimeout, mediator, eventBufferSize),
      HttpService.Name
    )
  }
  // $COVERAGE-ON$

  // $COVERAGE-OFF$
  protected def onTerminated(actor: ActorRef): Unit = {
    log.error("Terminating the system because {} terminated!", actor)
    context.system.terminate()
  }
  // $COVERAGE-ON$
}