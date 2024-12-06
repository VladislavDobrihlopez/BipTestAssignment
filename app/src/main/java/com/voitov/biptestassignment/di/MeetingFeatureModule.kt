package com.voitov.biptestassignment.di

import dagger.Module
import dagger.Provides
import java.net.MalformedURLException
import java.net.URL

@Module
abstract class MeetingFeatureModule {
    @Provides
    fun provideJitsiConferenceOptions(): JitsiConferenceOptions {
        val serverURL: URL
        serverURL = try {
            // When using JaaS, replace "https://meet.jit.si" with the proper serverURL
            URL("https://meet.jit.si/")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid server URL!")
        }
        val defaultOptions = JitsiMeetConferenceOptions.Builder()
            .setServerURL(serverURL)
            // When using JaaS, set the obtained JWT here
            //.setToken("MyJWT")
            // Different features flags can be set
            //.setFeatureFlag("toolbox.enabled", false)
            //.setFeatureFlag("filmstrip.enabled", false)
            .setFeatureFlag("pip.enabled", true)
            .setFeatureFlag("welcomepage.enabled", false)
            //.setFeatureFlag("prejoinpage.enabled", false)
            .setConfigOverride("customToolbarButtons", customToolbarButtons)
            .build()
        JitsiMeet.setDefaultConferenceOptions(defaultOptions)
    }
}
