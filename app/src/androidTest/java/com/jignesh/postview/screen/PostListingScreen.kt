package com.jignesh.postview.screen

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.*
import com.jignesh.postview.R
import org.hamcrest.Matcher

class PostListingScreen : Screen<PostListingScreen>() {
    class PostListingRecyclerItem(parent: Matcher<View>)
        : KRecyclerItem<PostListingRecyclerItem>(parent) {

        val userName: KTextView =
            KTextView(parent) { withId(R.id.tv_user_name) }
    }

    val recyclerInPostListing = KRecyclerView(
        { withId(R.id.recyclerView_post_linking) },
        { itemType(::PostListingRecyclerItem) })
}