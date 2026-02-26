package com.complexace.marginal.platform.ao3

import com.complexace.marginal.core.model.Platform
import com.complexace.marginal.core.PlatformRegistry

val AO3Platform = Platform(id = "ao3", displayName = "Archive of Our Own")

fun registerAO3() {
    PlatformRegistry.register(AO3Platform, AO3Connector())
}