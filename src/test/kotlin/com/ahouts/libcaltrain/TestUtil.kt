package com.ahouts.libcaltrain


internal fun <T> Class<T>.acquireResource(resource: String) =
    this.classLoader.getResourceAsStream("com/ahouts/libcaltrain/$resource")!!
