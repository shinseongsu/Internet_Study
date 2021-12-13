package cats

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

interface CatsService {
    suspend fun create(name: String, age: Int?): Int

    suspend fun all(): List<Cat>
}

class CatsServiceDB : CatsService {

    override suspend fun all(): List<Cat> {
        return transaction {
            Cats.selectAll().map {row ->
                row.asCat()
            }
        }
    }

    override suspend fun create(name: String, age: Int?): Int {
        val id = transaction {
            Cats.insertAndGetId { cat ->
                cat[Cats.name] = name
                if(age != null) {
                    cat[Cats.age] = age
                }
            }
        }
        return id.value
    }
}

private fun ResultRow.asCat() = Cat(
    this[Cats.id].value,
    this[Cats.name],
    this[Cats.age]
)

data class Cat(val id: Int,
               val name: String,
               val age: Int )