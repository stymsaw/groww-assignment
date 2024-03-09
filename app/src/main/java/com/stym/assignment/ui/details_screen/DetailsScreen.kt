package com.stym.assignment.ui.details_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetailsScreen(
    navController: NavHostController?,
) {

    val viewModel: DetailsVM = viewModel<DetailsVM>()
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ), title = {
                Text(
                    "Product Details Screen",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }, navigationIcon = {
                Icon(imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { navController?.popBackStack() })
            })
        },
    ) { it ->

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            val inputModifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(bottom = 20.dp)

            HorizontalPager(
                state = pagerState, modifier = Modifier.padding(bottom = 20.dp)
            ) {
                AsyncImage(
                    model = "",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(180.dp)
                        .clip(RectangleShape)
                        .border(2.dp, Color.Gray, shape = RectangleShape)
                )
            }

            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }
            }


            AsyncImage(
                model = "",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RectangleShape)
                    .border(2.dp, Color.Gray, shape = RectangleShape)
            )

            Box(Modifier.height(5.dp))
            Text(
                text = "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelLarge // Apply a subtitle style
            )
            Box(Modifier.height(5.dp))
            Text(text = "", maxLines = 1, overflow = TextOverflow.Ellipsis)
            Box(Modifier.height(5.dp))
            Text(
                text = "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Box(Modifier.height(5.dp))
            Text(text = "")
            Box(Modifier.height(5.dp))


        }
    }


}


@Preview(showBackground = true)
@Composable
fun ProductDetailsScreenPreview() {

    DetailsScreen(navController = null)
}