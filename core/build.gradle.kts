plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.gradle.get().pluginId)
}

android {
    namespace = "com.example.core"
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
}

dependencies {

    implementation(libs.bundles.ui.component)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.bundles.test.android.component)
}