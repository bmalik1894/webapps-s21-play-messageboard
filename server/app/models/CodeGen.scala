package models

object CodeGen extends App {
     slick.codegen.SourceCodeGenerator.run(
         "slick.jdbc.PostgresProfile",
         "org.postgresql.Driver",
         "jdbc:postgresql://localhost/bmalik?user=bmalik&password=0829294",
         "/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/",
         "models", None, None, true, false
     )
}