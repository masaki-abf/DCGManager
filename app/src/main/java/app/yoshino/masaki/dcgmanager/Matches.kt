package app.yoshino.masaki.dcgmanager

import android.database.AbstractWindowedCursor
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class Matches (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "game")var game: String,
    @ColumnInfo(name ="deck")var deck: String,
    @ColumnInfo(name = "first")var first: Boolean,
    @ColumnInfo(name = "win")var win: Boolean
)

