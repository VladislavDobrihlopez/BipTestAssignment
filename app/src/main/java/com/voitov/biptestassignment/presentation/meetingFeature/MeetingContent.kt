package com.voitov.biptestassignment.presentation.meetingFeature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voitov.biptestassignment.R
import com.voitov.biptestassignment.presentation.theme.BipTestAssignmentTheme

@Composable
fun MeetingContent(
    state: State,
    onRoomEntered: (String) -> Unit,
    onRoomEnterRequested: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = state.roomName, onValueChange = onRoomEntered, singleLine = true)

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onRoomEnterRequested) {
            Text(text = stringResource(R.string.meeting_feature_enter_the_room))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewMeetingContent_light() {
    BipTestAssignmentTheme {
        MeetingContent(
            state = State("lorem ipsum"),
            onRoomEntered = {},
            onRoomEnterRequested = { }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewMeetingContent_dark() {
    BipTestAssignmentTheme(darkTheme = true) {
        MeetingContent(
            state = State("lorem ipsum"),
            onRoomEntered = {},
            onRoomEnterRequested = { }
        )
    }
}