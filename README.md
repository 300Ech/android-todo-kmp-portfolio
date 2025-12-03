# Todo App KMP

A Todo application built with Kotlin Multiplatform and Compose Multiplatform. It shares 100% of the UI and business logic between Android and iOS.

## Tech Stack

*   **Kotlin Multiplatform**
*   **Compose Multiplatform** (UI)
*   **Room** (Database)
*   **Koin** (Dependency Injection)
*   **Coroutines & Flow**

## Architecture

Clean Architecture with MVVM:
*   **Domain**: Use Cases and Models
*   **Data**: Repository and Room implementation
*   **UI**: ViewModels and Compose screens

## How to Run

**Android**
```bash
./gradlew composeApp:installDebug
```

**iOS**
Open `iosApp/iosApp.xcodeproj` in Xcode and run.
