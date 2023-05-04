plugins {
    id(libs.plugins.agp.application.get().pluginId)
    id(libs.plugins.kotlin.gradle.get().pluginId)
}

android {
    namespace = "com.example.weatherapp"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.weatherapp"
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()
        versionCode = config.versions.versionCode.get().toInt()
        versionName = config.versions.versionName.get()

        testInstrumentationRunner = config.versions.testInstrumentationRunner.get()
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

    //Koin
    implementation(libs.koin.android)

    //NavComponent
    implementation(libs.bundles.navigation.component)

    implementation(project(":features:main"))
}