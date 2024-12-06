package com.voitov.biptestassignment.domain

class ValidateRoomNameUseCase {
    operator fun invoke(roomName: String): Result<String> {
        val formattedRoomName = roomName.trim()
        val hasBlackSymbol = formattedRoomName.any {
            blackSymbols.contains(it)
        }

        if (hasBlackSymbol) {
            return Result.failure(IllegalArgumentException("$formattedRoomName contains inappropriate symbols"))
        } else {
            return Result.success(formattedRoomName)
        }
    }

    private companion object {
        //const val PATTERN = "^[a-zA-Z0-9]+\$"
        val blackSymbols = arrayOf('?', '&', ':', ',', '%', '"')
       // val regex = Regex(PATTERN)
    }
}
