# Art Space

A small digital gallery that shows one artwork at a time with its title, artist and year, and lets you step through them.

Built while following Google's [Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course) course (the "Art Space" practice project).

## Features

- Framed artwork image with a title and "artist (year)" caption
- **Previous** / **Next** buttons to move between three artworks, wrapping back to the first
- Scrollable, edge-to-edge layout

## Built with

- Kotlin, Jetpack Compose, Material 3
- Screen state held with `remember { mutableStateOf(...) }`
- `buildAnnotatedString` for mixed-style caption text
- Min SDK 24, target/compile SDK 35

## Run it

1. Open the project folder in Android Studio and let Gradle sync.
2. Run the `app` configuration on an emulator or device (Android 7.0 / API 24 or newer).

Or, with a device or emulator connected:

```sh
./gradlew installDebug
```
