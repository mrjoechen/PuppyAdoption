/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

object PuppyRepo {

    private val Michaela = Puppy(
            id = 1,
            name = "Michaela",
            sex = Sex.Female,
            age = "Adult",
            color = "Yellow",
            location = "Shanghai",
            story = "Michaela was found as a stray injured when he was attached by another dog. Michaela" +
                    " does not get along well with other dogs, would do great as a single dog in a home." +
                    " Very cautious when first meeting, but a love bug and very obedient. " +
                    "He knows sit and stays with you with no reaction towards other dogs except being cautious with males because of his experience." +
                    " He's been coming out of his shell very nicely, wagging his tail and walking great on a leash. " +
                    "His foster says that he is just the best & will make a wonderful forever friend to some lucky adopter. Who knows, that could be you!",
            images = listOf(
                    R.drawable.puppy_1
            )
    )

    private val Rafael = Puppy(
            id = 2,
            name = "Rafael",
            sex = Sex.Male,
            age = "Young",
            color = "White - with Brown or Chocolate",
            location = "Guangzhou",
            story = "Rafael is a loving pup who just wants to be near her people. " +
                    "She likes sitting next to you on the couch watching tv, " +
                    "she like finding a free corner to sit and watch you cook in the kitchen, " +
                    "She's energetic and friendly and is searching for her perfect permanent family!",
            images = listOf(
                    R.drawable.puppy_2
            )
    )

    private val Cassiel = Puppy(
            id = 3,
            name = "Cassiel",
            sex = Sex.Female,
            age = "Young",
            color = "White",
            location = "Beijing",
            story = "Hello, my name is Cassiel! I was rescued from the shelter in honor of a dog who suffered a horrible fate there. " +
                    "I love people, but don't get along with most dogs. I am about 3 years old and looking for my forever family. " +
                    "If you think that is you please contact Ace of Hearts so we can meet!",
            images = listOf(
                    R.drawable.puppy_3
            )
    )

    private val Indira = Puppy(
            id = 4,
            name = "Indira",
            sex = Sex.Female,
            age = "Young",
            color = "White - with Brown or Chocolate",
            location = "Shanghai",
            story = "Indira was found as a stray by her foster, she is aprox. " +
                    "1 year old, very playful, and will be the perfect fit for an active family who is available to continue her puppy training.",
            images = listOf(
                    R.drawable.puppy_4
            )
    )

    private val Claudia = Puppy(
            id = 5,
            name = "Claudia",
            sex = Sex.Female,
            age = "4 years old, Young",
            color = "Brown",
            location = "Hangzhou",
            story = "Claudia is a super smart amazing dog with so much love to give. " +
                    "Claudia is well trained knows all commands sit, heal, go to your bed, stay on your bed, go to your crate, paw she knows it all. " +
                    "Claudia is very protective and so loving g she needs a experienced owner who keeps her in check and loves her. " +
                    "She loves to play with toys she is a great fetcher and will be the most loyal dog you will ever know. " +
                    "We require that you meet with our trainer and that you take 15 training sessions with our trainer. " +
                    "You will love our trainer he has been training for 30 years. Give Claudia a chance to be your forever best friend. " +
                    "She was abandoned and given up and hit in the face and she has come through it all.",
            images = listOf(
                    R.drawable.puppy_5
            )
    )

    private val Louise = Puppy(
            id = 6,
            name = "Louise",
            sex = Sex.Male,
            age = "Young",
            color = "Brown",
            location = "Shenzhen",
            story = "Louise loves affection, hikes and treats! He's playful and loves hiking in the canyons.His favorite dinner dish is sloppy joes. " +
                    "After dinner he's always excited to cuddle on the couch and watch The Voice. " +
                    "He is crate trained,he walks well on a leash now and wears a front clip harness to walk with. He is dog selective, " +
                    "if introduced correctly he can be good with another dog of his own size. He gets groomed every six weeks for anal gland expression and shedding. " +
                    "He is Incredibly loving, very smart and figured out how to get into our fridge. " ,
            images = listOf(
                    R.drawable.puppy_6
            )
    )


    val puppyList = listOf(
            Michaela, Rafael, Cassiel, Louise, Indira, Claudia
    )
}