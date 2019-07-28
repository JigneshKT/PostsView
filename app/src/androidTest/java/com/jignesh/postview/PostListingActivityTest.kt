package com.jignesh.postview

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.jignesh.postview.presentation.postlist.PostListingActivity
import com.jignesh.postview.screen.PostListingScreen
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class PostListingActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule<PostListingActivity>(PostListingActivity::class.java)

    private val postListingScreen = PostListingScreen()

    @Before
    fun setUp() {

    }

    @After
    fun after() {
    }

    @Test
    fun recyclerViewTest() {
        Thread.sleep(5000)  // Ideally, IdlingResource should be used but lack of time :)
        postListingScreen {
            recyclerInPostListing {
                isVisible()
                hasSize(100)
                firstChild<PostListingScreen.PostListingRecyclerItem> {
                    isVisible()
                    userName { hasText("Leanne Graham") }
                }
            }
        }
    }
}