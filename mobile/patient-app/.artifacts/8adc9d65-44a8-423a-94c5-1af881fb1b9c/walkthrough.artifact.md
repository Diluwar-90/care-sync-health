# Walkthrough - Login Session Persistence

I have implemented session persistence using `PreferenceDataStore` so that users remain logged in after a successful OTP verification.

## Changes Made

### Persistence Layer
#### [PreferenceDataStore.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/core/datastore/PreferenceDataStore.kt)
- Added `IS_LOGGED_IN` preference key.
- Implemented `isLoggedIn` Flow and `setLoggedIn` function.

### Authentication Flow
#### [OtpViewModel.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/auth/presentation/viewmodel/OtpViewModel.kt)
- Injected `VerifyOtpUseCase` and `PreferenceDataStore`.
- Implemented `verifyOtp()` which saves the login session upon successful verification.
#### [OtpScreen.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/auth/presentation/screen/OtpScreen.kt)
- Updated the "Verify OTP" button to trigger the verification logic.
- Added a navigation listener that automatically redirects to the Home screen when `isSuccess` is true.

### Startup logic
#### [SplashViewModel.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/splash/presentation/viewmodel/SplashViewModel.kt)
- Now checks both onboarding and login status from `PreferenceDataStore`.
#### [SplashScreen.kt](file:///Users/diluwar/development/care-sync-health/mobile/patient-app/app/src/main/java/com/healthcare/patient/feature/splash/presentation/screen/SplashScreen.kt)
- Implemented redirection logic based on the user's state:
    - New users -> Onboarding.
    - Returning (unauthenticated) users -> Login.
    - Authenticated users -> Main Dashboard.

## Verification Results
- **Build**: Successfully built the application (`:app:assembleDebug`).
- **Session Logic**: Verified that `PreferenceDataStore` correctly handles the `isLoggedIn` state.
- **Redirection**: Confirmed that `SplashScreen` now correctly branches between Onboarding, Login, and Main screens.
