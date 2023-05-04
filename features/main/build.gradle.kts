plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.gradle.get().pluginId)
}

android {
    namespace = "com.example.main"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()

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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //UI
    implementation(libs.bundles.ui.component)
    testImplementation(libs.test.junit)
    //Test
    androidTestImplementation(libs.bundles.test.android.component)

    //Koin
    implementation(libs.koin.android)

    //Paging
    implementation(libs.bundles.paging.component)

    //Navigation Component
    implementation(libs.bundles.navigation.component)

    //ViewBinding Delegate
    implementation(libs.binding)

    api(project(":features:main:data"))
    implementation(project(":core"))
}