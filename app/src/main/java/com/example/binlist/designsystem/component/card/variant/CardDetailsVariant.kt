package com.example.binlist.designsystem.component.card.variant

import com.example.binlist.utils.CommonString

enum class CardDetailsVariant(val id: Int, val title: Int) {
    FIRST(id = 0, title = CommonString.text_scheme_network),
    SECOND(id = 1, title = CommonString.text_type),
    THIRD(id = 2, title = CommonString.text_brand),
    FOURTH(id = 3, title = CommonString.text_prepaid),
    FIFTH(id = 4, title = CommonString.text_card_number),
    SIXTH(id = 5, title = CommonString.text_country),
    SEVENTH(id = 6, title = CommonString.text_bank),
    EIGHTH(id = 7, title = CommonString.text_bin)
}