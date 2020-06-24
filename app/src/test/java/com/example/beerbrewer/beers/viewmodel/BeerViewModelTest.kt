package com.example.beerbrewer.beers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.beerbrewer.beers.dagger.DaggerTestAppComponent
import com.example.beerbrewer.beers.dagger.TestAppModule
import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.example.beerbrewer.beers.data.repository.BeerRepository
import com.example.beerbrewer.beers.viewmodel.dagger.TestBeerModule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import java.net.UnknownHostException
import javax.inject.Inject

@RunWith(BlockJUnit4ClassRunner::class)
class BeerViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Inject
    lateinit var repository: BeerRepository

    @MockK
    private lateinit var viewModel: BeerViewModel

    private var beers: List<BeersResponseItem> = listOf(
        BeersResponseItem(
            4.5, 75.0, null, null,
            null, "A titillating, neurotic, peroxide punk of a Pale Ale.",
            null, null, null, null, null, null, null, null,
            "Trashy Blonde", null, null, null, null, null, null
        ),
        BeersResponseItem(
            0.4, 83.0, null, null,
            null, "apanese citrus fruit intensifies the sour nature of this German ",
            null, null, null, null, null, null, null, null,
            "Berliner Weisse With Yuzu ", null, null, null, null, null, null
        )
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        val testComponent = DaggerTestAppComponent.builder()
            .appModule(TestAppModule())
            .beerModule(TestBeerModule())
            .build()
        testComponent.inject(this)
        viewModel = BeerViewModel(repository)
    }

    @Test
    fun fetchBeers_SuccessTest() {

        //given
        every { repository.fetchBeers() } returns (Single.just(beers))

        //when
        viewModel.fetchBeers()

        //then
        Assert.assertEquals(viewModel.beerObservable.value, beers)

    }

    @Test
    fun fetchBeers_networkErrorTest() {

        //given
        every { repository.fetchBeers() } returns (Single.error(UnknownHostException("Unknown")))

        //when
        viewModel.fetchBeers()

        //then
        Assert.assertNotEquals(viewModel.beerObservable.value, beers)

    }

    @Test
    fun fetchBeers_otherErrorTest() {

        //given
        every { repository.fetchBeers() } returns (Single.error(RuntimeException("Unknown")))

        //when
        viewModel.fetchBeers()

        //then
        Assert.assertNotEquals(viewModel.beerObservable.value, beers)

    }
}