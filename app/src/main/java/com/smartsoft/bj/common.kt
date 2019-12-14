package com.smartsoft.bj


typealias VF = () -> Unit

enum class BjAction {
    Deal, Hit, Stay
}

typealias BjDispatch = (action: BjAction) -> Unit

enum class Page {
    Home, GameText, GameGraphic
}

typealias Nav = (page: Page) -> Unit