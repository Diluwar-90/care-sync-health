# Implementation Plan - Fix Platform SDK 36.1 Error in Multiple Modules

The project is failing to build because several newly added modules (`appointment`, `authentication`, `database`, `doctor`, `features`, `network`, `patient`) are using an invalid `compileSdk` version (`36.1`) which is not available in the Android SDK. This happened because they were likely created using a template that included a `release(36) { minorApiLevel = 1 }` block.

## Proposed Changes

### Build Configuration

I will update the `build.gradle.kts` files for all affected modules to use the standard `compileSdk` and `minSdk` versions from the version catalog (`libs.versions.toml`), which are already set correctly to `36` and `24` respectively.

#### [MODIFY] [appointment/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/appointment/build.gradle.kts)
#### [MODIFY] [authentication/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/authentication/build.gradle.kts)
#### [MODIFY] [database/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/database/build.gradle.kts)
#### [MODIFY] [doctor/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/doctor/build.gradle.kts)
#### [MODIFY] [features/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/features/build.gradle.kts)
#### [MODIFY] [network/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/network/build.gradle.kts)
#### [MODIFY] [patient/build.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/healthcare-mobile/patient/build.gradle.kts)

Each file will be updated as follows:
- Remove the `compileSdk { ... }` block.
- Replace it with `compileSdk = libs.versions.android.compileSdk.get().toInt()`.
- Replace `minSdk = 24` with `minSdk = libs.versions.android.minSdk.get().toInt()`.

## Verification Plan

### Automated Tests
- Run Gradle Sync to ensure all modules are correctly configured.
- Run `./gradlew assembleDebug` to verify that the build succeeds across all modules.
