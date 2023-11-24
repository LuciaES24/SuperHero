package com.lespsan543.superhero.Clases

import androidx.annotation.DrawableRes

data class Superhero(val superHeroName:String, val realName:String, val publisher:String, @DrawableRes val photo:Int)
