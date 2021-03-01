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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R

@Composable
fun HomePage() {
    val mainViewModel = viewModel<MainViewModel>()
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Adopt ", fontSize = 36.sp)

            Image(painter = painterResource(R.drawable.puppy), contentDescription = "logo")
            Text(text = " Puppy", fontSize = 36.sp)
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        PuppyList()
    }
}

@Composable
fun PuppyList() {
    val mainViewModel = viewModel<MainViewModel>()
    val list = mainViewModel.puppyList.observeAsState().value.orEmpty()
    LazyColumn(Modifier.fillMaxHeight()) {
        itemsIndexed(list) { index, item ->
            PuppyItem(index, item)
        }
    }
}
