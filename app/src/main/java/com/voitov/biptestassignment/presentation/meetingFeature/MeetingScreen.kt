package com.voitov.biptestassignment.presentation.meetingFeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MeetingScreen(viewModel: MeetingViewModel = viewModel()) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()

    MeetingContent(state = screenState, onRoomEntered = {
        viewModel.onEvent(Event.OnRoomChanged(it))
    }, onRoomEnterRequested = {
        viewModel.onEvent(Event.OnRoomEnterRequested)
    })
}
