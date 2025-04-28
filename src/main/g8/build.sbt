ThisBuild / name := "$name$"
ThisBuild / version := "$version$"
ThisBuild / scalaVersion := "$scalaVersion$"

resolvers ++= Seq(
  "apache-snapshots" at "https://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark"    %% "spark-core"         % "$sparkVersion$",
  "org.apache.spark"    %% "spark-sql"          % "$sparkVersion$",
  "org.apache.spark"    %% "spark-hive"         % "$sparkVersion$",
  "org.apache.spark"    %% "spark-graphx"       % "$sparkVersion$",
  "com.chuusai"         %% "shapeless"          % "2.3.12",
  "com.github.scopt"    %% "scopt"              % "4.1.0",
  "org.scalatest"       %% "scalatest"          % "3.2.19" % Test,
  "com.github.mrpowers" %% "spark-fast-tests"   % "1.3.0"  % Test
)

assembly /assemblyJarName := "$name;format="lower"$-fatjar-$version$.jar"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}


// test suite settings
Test / fork := true
// Show runtime of tests
Test / testOptions  += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

javaOptions ++= Seq(
  "-Xms512M",
  "-Xmx2048M",
  "--add-opens=java.base/java.lang=ALL-UNNAMED",
  "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
  "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
  "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
  "--add-opens=java.base/java.io=ALL-UNNAMED",
  "--add-opens=java.base/java.net=ALL-UNNAMED",
  "--add-opens=java.base/java.nio=ALL-UNNAMED",
  "--add-opens=java.base/java.util=ALL-UNNAMED",
  "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED",
  "--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED",
  "--add-opens=java.base/sun.security.action=ALL-UNNAMED",
  "--add-opens=java.base/sun.security.util=ALL-UNNAMED"
)
