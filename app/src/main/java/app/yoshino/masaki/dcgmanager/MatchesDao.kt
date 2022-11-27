package app.yoshino.masaki.dcgmanager

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.selects.select

@Dao
interface MatchesDao {
    @Insert
    fun insert (matches: Matches)

    @Update
    fun update (matches: Matches)

    @Delete
    fun delete (matches: Matches)

    @Query ("delete from matches")
    fun deleteAll()

    @Query("select * from matches")
    fun getAll(): List<Matches>

    @Query("select * from matches where id = :id")
    fun getMatches(id: Int): Matches

    @Query("select * from matches where win = :win")
    fun getWin(win: Boolean): List<Matches>

    @Query("select * from matches where game = :game")
    fun getGmae(game: String): List<Matches>
}