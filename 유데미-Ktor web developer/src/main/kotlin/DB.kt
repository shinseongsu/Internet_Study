import org.jetbrains.exposed.sql.Database

object DB {
    private val host = "localhost"
    private val port = 5432
    private val dbName = "postgres"
    private val dbUser = "postgres"
    private val dbPassword = "1111"

    fun connect(): Database {
        return Database.connect(
            "jdbc:postgresql://$host:$port/$dbName", driver = "org.postgresql.Driver",
            user = dbUser, password = dbPassword )
    }
}