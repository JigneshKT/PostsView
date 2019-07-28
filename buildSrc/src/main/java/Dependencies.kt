object PluginDependencies {
    val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object ProjectModules {
    val data = ":data"
    val domain = ":domain"
}

object ProjectDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val support = "androidx.appcompat:appcompat:${Versions.support}"
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"


    // retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"


    // dagger
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerAnnotationProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    // RxKotlin
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    // ui
    val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val material =  "com.google.android.material:material:${Versions.material}"

    //spinkit
    val spinkit = "com.github.ybq:Android-SpinKit:${Versions.spinkit}"

    //picasso
    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

    val javaxAnnotation =  "javax.annotation:jsr250-api:${Versions.javax_annotation}"
    val javaxInject =  "javax.inject:javax.inject:${Versions.javax_inject}"

    val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
}

object ProjectTestDependencies{
    // tests
    val junit = "junit:junit:${Versions.junit}"
    val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    val mockitoKotlin = "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlin}"
    val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockitoAndroid}"
    val androidTestRunner = "androidx.test.ext:junit:${Versions.androidTestRunner}"
    val androidTestRule = "androidx.test:rules:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val lifecycleTesting = "android.arch.core:core-testing:${Versions.lifecycle}"
    val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"

}



object Versions {
    val gradleAndroidPlugin = "3.4.1"
    val kotlin = "1.3.40"

    val compileSdk = 29
    val targetSdk = 29
    val minSdkVersion = 15
    val releaseVersionCode = 1
    val releaseVersionName = "1.0.0"


    val support = "1.0.2"
    val androidx_core = "1.0.2"

    val retrofit = "2.4.0"
    val loggingInterceptor = "3.11.0"
    val dagger = "2.16"
    val rxkotlin = "2.3.0"
    val rxandroid = "2.1.0"


    val constraintLayout = "1.1.3"
    val material = "1.0.0-rc02"


    val javax_annotation = "1.0"
    val javax_inject= "1"

    val spinkit = "1.1.0"
    val picasso = "2.71828"

    val junit = "4.12"
    val assertJ = "3.9.1"
    val mockito = "2.22.0"
    val mockitoKotlin = "1.6.0"
    val mockitoAndroid = "2.6.1"
    val androidTestRunner = "1.1.0"
    val espresso = "3.2.0"
    val lifecycle = "2.0.0"
    val kakao = "2.1.0"


}