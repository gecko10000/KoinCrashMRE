package com.example.koincrashmre

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val module = module {
    singleOf(::TestDIClass)
}
