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
package com.example.androiddevchallenge.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.ext.percentOffsetX
import com.example.androiddevchallenge.ui.theme.typography
import androidx.compose.runtime.livedata.observeAsState

import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun DetailPage() {
    val mainViewModel = viewModel<MainViewModel>()
    val showingDetail = mainViewModel.showDetail.observeAsState().value ?: false
    val puppy = mainViewModel.puppyDetail.value

    val percentOffset = animateFloatAsState(targetValue = if (showingDetail) 0f else 1f)

    DetailContent(puppy = puppy, percentOffset = percentOffset.value)
}

@Composable
fun DetailContent(puppy: Puppy?, percentOffset: Float) {

    Column(
        Modifier
            .percentOffsetX(percentOffset)
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        if (puppy != null) {

            Spacer(modifier = Modifier.height(40.dp))
            Text(text = puppy.name, fontSize = 36.sp)
            Spacer(modifier = Modifier.height(10.dp))

            val pageState = remember {
                PagerState().apply {
                    minPage = 0
                    maxPage = (puppy.images.size - 1).coerceAtLeast(0)
                }
            }
            Pager(state = pageState, modifier = Modifier.height(350.dp)) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 16.dp)
                        .fillMaxSize()
                        .shadow(20.dp)
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(id = puppy.images[page]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            val currentPage = pageState.currentPage
            val maxPage = pageState.maxPage
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "${currentPage + 1}/${maxPage + 1}")
            }

            Column(
                Modifier
                    .weight(1f)
                    .height(0.dp)
                    .padding(start = 20.dp, end = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Row {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "My name is ${puppy.name}!",
                        style = typography.h6,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.size(1.dp))

                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically),
                        colorFilter = ColorFilter.tint(puppy.sex.color),
                        imageVector = puppy.sex.label, contentDescription = null
                    )
                }

                Divider(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(modifier = Modifier.padding(top = 3.dp)) { ProfileItem("Age", puppy.age) }
                    Row(modifier = Modifier.padding(top = 3.dp)) {
                        ProfileItem(
                            "Color",
                            puppy.color
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = puppy.story)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20)),
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xFF03DAC5)
                )

            ) {
                Text(text = "Adopt ❤️ me", color = Color.Green)
            }
            Spacer(modifier = Modifier.height(20.dp))
        } else {
            Spacer(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ProfileItem(key: String, value: String) {
    Text(
        key, modifier = Modifier.width(70.dp),
        fontWeight = FontWeight.Bold
    )
    Text(value, fontWeight = FontWeight.Light)
}
