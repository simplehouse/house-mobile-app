package io.devmartynov.house.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.devmartynov.house.R

val GilroyFontBold = FontFamily(Font(R.font.gilroy_bold))
val GilroyFontSemibold = FontFamily(Font(R.font.gilroy_semibold))
val GilroyFontMedium = FontFamily(Font(R.font.gilroy_medium))
val GilroyFontRegular = FontFamily(Font(R.font.gilroy_regular))

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = GilroyFontBold,
        fontSize = 30.sp,
        lineHeight = 37.sp,
        color = Black,
    ),
    h2 = TextStyle(
        fontFamily = GilroyFontSemibold,
        fontSize = 22.sp,
        lineHeight = 27.sp,
        color = Black,
    ),
    body1 = TextStyle(
        fontFamily = GilroyFontRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = LightBlack,
    ),
    button = TextStyle(
        fontFamily = GilroyFontSemibold,
        fontSize = 16.sp,
        color = White,
    ),
    caption = TextStyle(
        fontFamily = GilroyFontMedium,
        fontSize = 10.sp,
        color = InputCaption,
    )
)