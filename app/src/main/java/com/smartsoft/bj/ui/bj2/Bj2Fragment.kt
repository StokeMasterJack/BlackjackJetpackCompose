package com.smartsoft.bj.ui.bj2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent
import com.smartsoft.bj.GameText
import com.smartsoft.bj.R

class Bj2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bj2, container, false) as ViewGroup
        root.setContent {
            GameText()
        }
        return root
    }
}

