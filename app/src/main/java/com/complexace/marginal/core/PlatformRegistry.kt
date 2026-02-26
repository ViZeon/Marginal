package com.complexace.marginal.core

import com.complexace.marginal.core.interfaces.PlatformConnector
import com.complexace.marginal.core.model.Platform

object PlatformRegistry {
    private val connectors = mutableMapOf<String, PlatformConnector>()

    fun register(platform: Platform, connector: PlatformConnector) {
        connectors[platform.id] = connector
    }

    fun getConnector(platformId: String): PlatformConnector? = connectors[platformId]
    fun all(): List<Platform> = connectors.keys.map { Platform(it, connectors[it]!!.displayName) }
}