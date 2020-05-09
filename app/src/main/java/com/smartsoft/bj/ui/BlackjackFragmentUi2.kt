package com.smartsoft.bj.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Recomposer
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent
import com.smartsoft.bj.R

class BlackjackFragmentUi2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bj2, container, false) as ViewGroup

        root.setContent(Recomposer.current()) {
            ProvideTheme {
                Blackjack2()
            }

        }

        return root
    }
}

