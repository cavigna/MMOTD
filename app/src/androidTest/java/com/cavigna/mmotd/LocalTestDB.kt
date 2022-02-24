package com.cavigna.mmotd

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.cavigna.mmotd.model.local.db.BaseDeDatos
import com.cavigna.mmotd.model.local.db.GameDao
import com.cavigna.mmotd.model.models.Game
import com.cavigna.mmotd.model.models.GameDetail
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named


@HiltAndroidTest
@SmallTest
class LocalTestDB {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test.db")
    lateinit var db: BaseDeDatos

    private lateinit var  dao: GameDao

    @Before
    fun init(){
        hiltRule.inject()
        dao = db.dao
    }

    @After
    fun tearDown() {
        db.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertListOfGames() = runBlockingTest {
        val game = Game(1523)
        dao.insertGames(listOf(game))

        val listOfGames = dao.selectAllGames()

        assertThat(listOfGames).contains(game)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertGameDetail() = runBlockingTest {
        val gameDetail = GameDetail(1523)
        dao.insertGameDetail(gameDetail)
        val gameDB = dao.selectGameDetail(1523)
        assertThat(gameDB).isEqualTo(gameDetail)
    }
}