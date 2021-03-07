package com.example.androiddevchallenge.utils

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.menu.MenuItem
import com.example.androiddevchallenge.ui.home.newpets.NewPet
import com.example.androiddevchallenge.ui.home.pets.Pet
import com.example.androiddevchallenge.ui.onboarding.OnBoardingItem

object PuppyDataManager {

    val onBoardingItems by lazy { generateOnBoardingItems() }

    val menuItems by lazy { generateMenuItems() }

    val pets by lazy { generatePetsItems() }

    val newPets by lazy { generateNewPets() }

    private fun generateNewPets(): List<NewPet> {
        val list = mutableListOf<NewPet>()
        list.add(
            NewPet(
                1,
                "Rayo",
                "https://images.pexels.com/photos/1170986/pexels-photo-1170986.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "Surco",
                7.5
            )
        )
        list.add(
            NewPet(
                2,
                "Flash",
                "https://images.pexels.com/photos/4383760/pexels-photo-4383760.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "Lince",
                12.5
            )
        )
        list.add(
            NewPet(
                3,
                "Gluglu",
                "https://images.pexels.com/photos/5277693/pexels-photo-5277693.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "Magdalena",
                5.1
            )
        )
        list.add(
            NewPet(
                4,
                "Rambo",
                "https://images.pexels.com/photos/1805164/pexels-photo-1805164.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "San Isidro",
                18.5
            )
        )
        list.add(
            NewPet(
                5,
                "Simba",
                "https://images.pexels.com/photos/151511/pexels-photo-151511.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "Pachacamac",
                18.5
            )
        )
        return list
    }

    private fun generatePetsItems(): List<Pet> {
        val list = mutableListOf<Pet>()

        list.add(
            Pet(
                1,
                "Amber",
                "Labrador",
                "Male",
                2,
                10,
                "Grecia Vargas",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. ",
                true,
                7.5,
                arrayListOf(
                    "https://images.pexels.com/photos/1739095/pexels-photo-1739095.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    "https://images.pexels.com/photos/1790446/pexels-photo-1790446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    "https://images.pexels.com/photos/1790444/pexels-photo-1790444.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                )

            )
        )

        list.add(
            Pet(
                2,
                "Sussy",
                "Bulldog",
                "Female",
                1,
                7,
                "Lupa Rodriguez",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. ",
                false,
                10.1,
                arrayListOf(
                    "https://images.pexels.com/photos/4587987/pexels-photo-4587987.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                    "https://images.pexels.com/photos/4587987/pexels-photo-4587987.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                    "https://images.pexels.com/photos/4587998/pexels-photo-4587998.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                )

            )
        )

        list.add(
            Pet(
                3,
                "Bobby",
                "Boxer",
                "Male",
                3,
                20,
                "Luis Santana",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. ",
                false,
                3.0,
                arrayListOf(
                    "https://images.pexels.com/photos/605496/pexels-photo-605496.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                    "https://images.pexels.com/photos/53769/pexels-photo-53769.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    "https://images.pexels.com/photos/2124401/pexels-photo-2124401.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                )

            )
        )

        list.add(
            Pet(
                3,
                "Lucas",
                "Shih Tzu",
                "Male",
                7,
                8,
                "Angel Perales",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. ",
                true,
                1.7,
                arrayListOf(
                    "https://images.pexels.com/photos/130770/pexels-photo-130770.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                    "https://images.pexels.com/photos/130765/pexels-photo-130765.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    "https://images.pexels.com/photos/936317/pexels-photo-936317.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                )

            )
        )

        return list
    }

    private fun generateMenuItems(): List<MenuItem> {
        val list = mutableListOf<MenuItem>()

        list.add(MenuItem(1, "Dogs", R.drawable.pet_icon))
        list.add(MenuItem(2, "Cats", R.drawable.cat_icon))
        list.add(MenuItem(3, "Birds", R.drawable.owl_icon))
        list.add(MenuItem(4, "Hamsters", R.drawable.hamster_icon))
        list.add(MenuItem(5, "Rabits", R.drawable.rabit_icon))
        return list
    }

    private val onBoardingColors = listOf(
        Color(0xFFFFF59E),
        Color(0xFFFFCC81),
        Color(0xFFFED176),
    )

    private val onBoardingTitle = listOf(
        "Welcome to our \napp",
        "Find the nearest pet \nfrom your location",
        "Make \nnew friends",
    )

    private val onBoardingDescription = listOf(
        "With our app you'll make life of our \nfurry friends happier",
        "Choose a location of your for finding \nthe nearest animals for you",
        "Here you can meet your dream friends and \njoy with them",
    )

    private val onBoardingItemsUrl = listOf(
        "https://image.freepik.com/vector-gratis/lindo-perro-jugando-ilustracion-dibujos-animados-caja-concepto-naturaleza-animal-aislado-plano-dibujos-animados_138676-2297.jpg",
        "https://image.freepik.com/vector-gratis/lindo-pastor-australiano_138676-2071.jpg",
        "https://image.freepik.com/vector-gratis/lindo-perro-sentado-ilustracion-vectorial-dibujos-animados-vector-aislado-concepto-amor-animal-estilo-dibujos-animados-plana_138676-2031.jpg",
    )

    private fun generateOnBoardingItems(): List<OnBoardingItem> {
        val list = mutableListOf<OnBoardingItem>()
        for (i in 0..2) {
            list.add(
                OnBoardingItem(
                    i,
                    onBoardingTitle[i],
                    onBoardingDescription[i],
                    onBoardingColors[i],
                    onBoardingItemsUrl[i]
                )
            )
        }
        return list;
    }
}