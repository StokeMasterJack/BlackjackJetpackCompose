package com.smartsoft.bj.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.Recomposer
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.ImageAsset
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.smartsoft.bj.R
import java.util.*

enum class HomeAction {
    Bj1, Bj2
}

typealias HomeDispatch = (action: HomeAction) -> Unit

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup

        root.setContent(Recomposer.current()) {
            ProvideTheme {
                Home()
            }

        }

        return root
    }
}

@Composable
fun Fragment.Home() {

    fun dispatch(action: HomeAction) {
        when (action) {
            HomeAction.Bj1 -> findNavController().navigate(R.id.navigation_bj1)
            HomeAction.Bj2 -> findNavController().navigate(R.id.navigation_bj2)
        }
    }

    HomeVu(::dispatch)

}


@Composable
fun HomeVu(dispatch: HomeDispatch = {}) {
    val imageAsset: ImageAsset = imageResource(R.drawable.blackjack)

    Column {
        Box(
            modifier = Modifier.heightIn(minHeight = 360.dp).fillMaxWidth().padding(30.dp)
        ) {
            Image(
                asset = imageAsset,
                modifier = Modifier
                    .preferredHeightIn(maxHeight = 180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
            )
        }

//        val imageModifier = Modifier
//            .preferredHeightIn(maxHeight = 180.dp)
//            .fillMaxWidth()
//            .clip(shape = RoundedCornerShape(4.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalGravity = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            Column(
                horizontalGravity = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {

                val buttonCaption1 = "Play Game - UI 1".toUpperCase(Locale.getDefault())
                Button(
                    text = { Text(buttonCaption1) },
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        dispatch(HomeAction.Bj1)
                    }
                )

                val buttonCaption2 = "Play Game - UI 2".toUpperCase(Locale.getDefault())
                Button(
                    text = { Text(buttonCaption2) },
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        dispatch(HomeAction.Bj2)
                    }
                )
            }
        }
        Column(modifier = Modifier.padding(30.dp)) {

        }
    }

}


@Preview
@Composable
fun GameTextPreview() {
    MaterialTheme {
        HomeVu()
    }
}