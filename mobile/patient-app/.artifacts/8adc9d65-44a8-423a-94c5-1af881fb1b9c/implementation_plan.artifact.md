# Implementation Plan - Save Login Session after OTP Verification

This plan outlines the changes needed to save the user's login session using `PreferenceDataStore` after a successful OTP verification and ensure the `SplashScreen` correctly redirects logged-in users to the main dashboard.

## Proposed Changes

### [Core: DataStore]

#### [MODIFY] [PreferenceDataStore.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/core/datastore/PreferenceDataStore.kt)
- Add `IS_LOGGED_IN` preference key.
- Add `isLoggedIn: Flow<Boolean>` property.
- Add `setLoggedIn(Boolean)` suspend function to update the login status.

---

### [Feature: Auth]

#### [MODIFY] [OtpViewModel.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/auth/presentation/viewmodel/OtpViewModel.kt)
- Inject `VerifyOtpUseCase` and `PreferenceDataStore`.
- Add `verifyOtp()` function that:
    - Calls the use case (using a placeholder phone number for now as it's not yet passed in navigation).
    - On success, calls `PreferenceDataStore.setLoggedIn(true)`.
    - Updates a new `isSuccess` property in `OtpUiState` or triggers a navigation event.

#### [MODIFY] [OtpUiState.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/auth/presentation/state/OtpUiState.kt)
- Add `isSuccess: Boolean` flag (default `false`).

#### [MODIFY] [OtpScreen.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/auth/presentation/screen/OtpScreen.kt)
- Update "Verify OTP" button `onClick` to call `viewModel.verifyOtp()`.
- Add a `LaunchedEffect` to observe `uiState.isSuccess` and call `onNavigateToHome()` when true.

#### [MODIFY] [AuthModule.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/auth/di/AuthModule.kt)
- Update `OtpViewModel` definition to include injected dependencies: `get()` for UseCase and `get()` for DataStore.

---

### [Feature: Splash]

#### [MODIFY] [SplashUiState.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/splash/presentation/state/SplashUiState.kt)
- Add `isLoggedIn: Boolean?` (default `null`).

#### [MODIFY] [SplashViewModel.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/splash/presentation/viewmodel/SplashViewModel.kt)
- Inject `PreferenceDataStore`.
- Update `checkOnboardingStatus()` to also check `isLoggedIn` from `PreferenceDataStore`.
- Update `SplashUiState` with both results.

#### [MODIFY] [SplashScreen.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/splash/presentation/screen/SplashScreen.kt)
- Update `LaunchedEffect` logic:
    - If `isOnboardingCompleted == false` -> Navigate to Onboarding.
    - If `isOnboardingCompleted == true` AND `isLoggedIn == true` -> Navigate to Home.
    - If `isOnboardingCompleted == true` AND `isLoggedIn == false` -> Navigate to Login.

## Verification Plan

### Automated Tests
- Build the project to ensure DI and references are correct.
- `gradle_build(":app:assembleDebug")`

### Manual Verification
- Deploy the app.
- Complete onboarding (if not done).
- Go to Login -> OTP.
- Click "Verify OTP".
- Verify it navigates to Home.
- Kill the app and restart.
- Verify it lands directly on the Home screen (bypassing Login).
