plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.gradle.get().pluginId)
}

android {
    namespace = "com.example.data"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()

        buildConfigField("String", "API_KEY", "\"8349686e1d8b4c87b44122011231802\"")
        buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/v1/\"")
        testInstrumentationRunner = config.versions.testInstrumentationRunner.get()
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(config.versions.getDefaultProguardFile.get()),
                config.versions.proguardFiles.get()
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = options.versions.jvmTarget.get()
    }
}

dependencies {
    //UI
    implementation(libs.bundles.ui.component)
    //Test
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.bundles.test.android.component)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.gson.converter)

    //OkHttp
    implementation(libs.bundles.okhttp.component)

    //Paging
    implementation(libs.bundles.paging.component)

    //Coroutine
    implementation(libs.coroutines.core)

    //Koin
    implementation(libs.koin.android)

    api(project(":features:main:domain"))
}