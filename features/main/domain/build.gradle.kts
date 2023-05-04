plugins {
    id("java-library")
    id(libs.plugins.kotlin.jvm.get().pluginId   )
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
dependencies {
    api(project(":common"))

    //Coroutine
    implementation(libs.coroutines.core)

    //Paging
    implementation(libs.paging.common)

    //Koin
    implementation(libs.koin.core)
}