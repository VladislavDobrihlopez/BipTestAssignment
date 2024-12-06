package com.voitov.biptestassignment.presentation.meetingFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voitov.biptestassignment.domain.ValidateRoomNameUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MeetingViewModel(
    private val validationUseCase: ValidateRoomNameUseCase,
) : ViewModel() {
    val sideEffects = Channel<SideEffect>(capacity = Channel.BUFFERED)

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun onEvent(event: Event) {
        when (event) {
            is Event.OnRoomChanged -> handleRoomChange(text = event.text)
            Event.OnRoomEnterRequested -> handleRoomEntrance()
        }
    }

    private fun handleRoomChange(text: String) {
        validationUseCase(roomName = text)
            .onSuccess { validatedRoomName ->
                _state.update {
                    it.copy(roomName = validatedRoomName)
                }
            }
            .onFailure {
                viewModelScope.launch {
                    sideEffects.send(SideEffect.ValidationError)
                }
            }
    }

    private fun handleRoomEntrance() {

    }
}

sealed interface SideEffect {
    data object ValidationError : SideEffect
}

data class State(val roomName: String = "")

sealed interface Event {
    data object OnRoomEnterRequested : Event
    data class OnRoomChanged(val text: String) : Event
}
