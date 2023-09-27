# Code Challenge Documentation

## Introduction

This document provides an overview of the code challenge completed by **Hussein Habibi Juybari**. The challenge involved developing an Android application in Kotlin, following best practices and utilizing various libraries and architectural patterns.

## Project Overview

- **Programming Language**: Kotlin
- **UI**: Android XML (Layouts)
- **Architecture**: Clean Architecture (Data, Domain, Presentation/UI layers)
- **Data Flow**: Coroutine Flow for ViewModel-to-View communication
- **Dependency Injection**: Dagger Hilt 2
- **Network Requests**: Retrofit 2
- **Image Handling**: Glide for image downloading and caching
- **Location**: MapView for user location
- **Google Maps API Key**: Hardcoded in AndroidManifest.xml for quick testing (not suitable for production)
- **Data Binding**: Used for handling complex code with views
- **Design System**: Created based on design URL in PDF documentation, including fonts, colors, and themes
- **Dark Mode**: Not supported (pending implementation)
- **Unit Tests**: Two unit tests for UseCases
- **Navigation**: Jetpack Navigation Component

## Code Structure

The code is organized according to the Clean Architecture pattern, with three main layers:

1. **Data Layer**: Contains data sources (In this case it's only APIs) and repositories to manage data access.

2. **Domain Layer**: Defines use cases and business logic. It is independent of Android-specific code.

3. **Presentation/UI Layer**: Handles UI components, ViewModel, and View. Communicates with the Domain layer using UseCases and Coroutines Flow for data updates.

## Key Libraries and Dependencies

- **Dagger Hilt 2**: Used for dependency injection, ensuring clean and modular code.
- **Retrofit 2**: Handles network requests efficiently.
- **Glide**: Manages image downloading and caching.
- **Map View**: Utilized for user location.
- **Google Maps API Key**: Hardcoded for quick testing.
- **Data Binding**: Simplifies complex code interactions with views.
- **Jetpack Navigation Component**: Facilitates navigation between screens.

## Design System

A design system has been implemented based on the design URL provided in the PDF documentation. It includes defined fonts, colors, and themes for a consistent user interface.

## Dark Mode

Dark mode support is not implemented in the current version of the application but may be considered for future development.

## Unit Tests

Two unit tests have been written to ensure the functionality of UseCases.

## Conclusion

**Hussein Habibi Juybari** has successfully completed the code challenge by developing an Android application in Kotlin, following best practices in architecture, dependency management, and data handling. The project demonstrates proficiency in various Android technologies and libraries, with potential for further enhancements such as dark mode support and improved API key handling for production use.
