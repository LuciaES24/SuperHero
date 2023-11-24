package com.lespsan543.practica04.Screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lespsan543.superhero.Clases.Superhero
import com.lespsan543.superhero.R

fun getSuperHeroes() : MutableList<Superhero>{
    val listaSuperHero = mutableListOf<Superhero>()
    val spiderman = Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman)
    val wolverine = Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan)
    val batman = Superhero( "Batman", "Bruce Wayne", "DC", R.drawable.batman)
    val thor = Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor)
    val flash = Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash)
    val greenLantern = Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern)
    val wonderWoman = Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)

    listaSuperHero.add(spiderman)
    listaSuperHero.add(wolverine)
    listaSuperHero.add(batman)
    listaSuperHero.add(thor)
    listaSuperHero.add(flash)
    listaSuperHero.add(greenLantern)
    listaSuperHero.add(wonderWoman)

    return listaSuperHero
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(getSuperHeroes()) {
            ItemHero(superhero = it, onItemSelected= {Toast.makeText(context,it.realName,Toast.LENGTH_SHORT).show()})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroView2() {
    val context = LocalContext.current
    LazyVerticalGrid(
        //GridCells.Fixed(2)
        GridCells.Adaptive(130.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ) {
        items(getSuperHeroes()) {
            ItemHero(superhero = it, onItemSelected= {Toast.makeText(context,it.realName,Toast.LENGTH_SHORT).show()})
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero,
             onItemSelected : (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) }){
        Column {
            Image(
                painterResource(id = superhero.photo ),
                contentDescription = "SuperHero Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = superhero.superHeroName,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superhero.realName,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superhero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp))
        }
    }
}