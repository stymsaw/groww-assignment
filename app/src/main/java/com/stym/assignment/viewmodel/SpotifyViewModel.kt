package com.stym.assignment.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stym.assignment.BaseApplication
import com.stym.assignment.data.repository.SpotifyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpotifyViewModel @Inject constructor(
    val spotifyRepository: SpotifyRepository,
) :
    ViewModel() {

    //search is happening or not
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    //text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun callAPI() {
        viewModelScope.launch {
            spotifyRepository.getSearchedResult(
                query = "tum hi ho",
                type = "",
                authToken = BaseApplication.getAccessToken() ?: ""
            )



        }


    }

//    third state the list to be filtered
//    private val _countriesList = MutableStateFlow(countries)
//    val countriesList = searchText
//        .combine(_countriesList) { text, countries ->//combine searchText with _contriesList
//            if (text.isBlank()) { //return the entery list of countries if not is typed
//                countries
//            }
//            countries.filter { country ->// filter and return a list of countries based on the text the user typed
//                country.uppercase().contains(text.trim().uppercase())
//            }
//        }.stateIn(//basically convert the Flow returned from combine operator to StateFlow
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),//it will allow the StateFlow survive 5 seconds before it been canceled
//            initialValue = _countriesList.value
//        )

}