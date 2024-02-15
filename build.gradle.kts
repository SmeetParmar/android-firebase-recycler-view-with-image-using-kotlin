import org.jetbrains.kotlin.gradle.plugin.*

buildscript {
    repositories {
        google()
    }
    dependencies {
//classpath("com.android.tools.build:gradle:4.0.0")
        classpath("com.google.gms:google-services:4.4.0")
    }
}

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.gms.google-services") version "4.4.0"
}