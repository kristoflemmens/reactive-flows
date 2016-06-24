import sbt._

object Version {
  final val Akka                     = "2.4.14"
  final val AkkaHttp                 = "10.0.0"
  final val AkkaHttpJson             = "1.11.0"
  final val AkkaLog4j                = "1.2.0"
  final val AkkaPersistenceCassandra = "0.21"
  final val AkkaSse                  = "2.0.0-M5"
  final val Circe                    = "0.6.1"
  final val Constructr               = "0.15.0"
  final val Log4j                    = "2.7"
  final val Scala                    = "2.12.0"
  final val ScalaTest                = "3.0.1"
}

object Library {
  val akkaClusterSharding        = "com.typesafe.akka"        %% "akka-cluster-sharding"              % Version.Akka
  val akkaDistributedData        = "com.typesafe.akka"        %% "akka-distributed-data-experimental" % Version.Akka
  val akkaPersistenceCassandra   = "com.typesafe.akka"        %% "akka-persistence-cassandra"         % Version.AkkaPersistenceCassandra
  val akkaHttp                   = "com.typesafe.akka"        %% "akka-http"                          % Version.AkkaHttp
  val akkaHttpCirce              = "de.heikoseeberger"        %% "akka-http-circe"                    % Version.AkkaHttpJson
  val akkaHttpTestkit            = "com.typesafe.akka"        %% "akka-http-testkit"                  % Version.AkkaHttp
  val akkaLog4j                  = "de.heikoseeberger"        %% "akka-log4j"                         % Version.AkkaLog4j
  val akkaMultiNodeTestkit       = "com.typesafe.akka"        %% "akka-multi-node-testkit"            % Version.Akka
  val akkaSse                    = "de.heikoseeberger"        %% "akka-sse"                           % Version.AkkaSse
  val akkaTestkit                = "com.typesafe.akka"        %% "akka-testkit"                       % Version.Akka
  val circeGeneric               = "io.circe"                 %% "circe-generic"                      % Version.Circe
  val circeJava8                 = "io.circe"                 %% "circe-java8"                        % Version.Circe
  val constructr                 = "de.heikoseeberger"        %% "constructr"                         % Version.Constructr
  val constructrCoordinationEtcd = "de.heikoseeberger"        %% "constructr-coordination-etcd"       % Version.Constructr
  val log4jCore                  = "org.apache.logging.log4j" %  "log4j-core"                         % Version.Log4j
  val log4jSlf4jImpl             = "org.apache.logging.log4j" %  "log4j-slf4j-impl"                   % Version.Log4j
  val scalaTest                  = "org.scalatest"            %% "scalatest"                          % Version.ScalaTest
}
