package com.stym.assignment.ui.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.stym.assignment.ui.common.AudioCard
import com.stym.assignment.viewmodel.SpotifyViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavHostController?) {

    val viewModel = hiltViewModel<SpotifyViewModel>()

    //Collecting states from ViewModel
    val searchText by viewModel.searchText.collectAsState()
//    val isSearching by viewModel.isSearching.collectAsState()
//    val countriesList by viewModel.countriesList.collectAsState()

    val modifier = Modifier.fillMaxWidth()
    val pagerState1 = rememberPagerState(pageCount = { 10 })
    val pagerState2 = rememberPagerState(pageCount = { 10 })
    val pagerState3 = rememberPagerState(pageCount = { 10 })
    val pagerState4 = rememberPagerState(pageCount = { 10 })

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val imgUrl = "https://i.scdn.co/image/ab67616d0000b2736404721c1943d5069f0805f3"


    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()

    ) {
        TextField(
            value = searchText,
            modifier = modifier.padding(10.dp),
            placeholder = { Text(text = "Search your fav song") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            onValueChange = {
                viewModel.onSearchTextChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search, contentDescription = "search icon",
                    )
            },
            trailingIcon = {
                if (searchText.isNotEmpty()) Icon(imageVector = Icons.Outlined.Close,
                    contentDescription = "clear search",
                    modifier = Modifier.clickable {
                        viewModel.callAPI()
                        viewModel.onSearchTextChange("")
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    })
            },
        )

        Text(text = "Albums", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        HorizontalPager(
            state = pagerState1, pageSize = PageSize.Fixed(180.dp)
        ) {
            AudioCard(categoryName = "item.name", categoryImage = imgUrl)
        }

        Text(text = "Tracks ", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        HorizontalPager(
            state = pagerState2, pageSize = PageSize.Fixed(180.dp)
        ) {
            AudioCard(categoryName = "item.name", categoryImage = imgUrl)
        }
        Text(text = "Playlists", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        HorizontalPager(
            state = pagerState3, pageSize = PageSize.Fixed(180.dp)
        ) {
            AudioCard(categoryName = "item.name", categoryImage = imgUrl)
        }
        Text(text = "Artists", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        HorizontalPager(
            state = pagerState4, pageSize = PageSize.Fixed(180.dp)
        ) {
            AudioCard(categoryName = "item.name", categoryImage = imgUrl)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen(null)
}