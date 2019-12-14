package com.smartsoft.bj.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.fragment.app.Fragment
import androidx.ui.core.Clip
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import com.smartsoft.bj.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup
        root.setContent {
            Home()
        }
        return root
    }
}

@Composable
fun Home() {
    val image: Image = +imageResource(R.drawable.blackjack)
    Container(
        modifier = MinHeight(360.dp) wraps ExpandedWidth wraps Spacing(30.dp),
        padding = EdgeInsets(10.dp)
    ) {
        Clip(shape = RoundedCornerShape(4.dp)) {
            DrawImage(image)
        }
    }
}


@Preview
@Composable
fun GameTextPreview() {
    MaterialTheme {
        Home()
    }
}