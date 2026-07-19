# Implementation Plan - Fix Gradle Daemon Termination (AndroidLocationsException)

The project build is failing because the Android Gradle Plugin (AGP) detects multiple environment variables for the Android preferences folder (`ANDROID_PREFS_ROOT` and `ANDROID_USER_HOME`). Even though they point to the same location, AGP 8.x requires only one to be set, preferably `ANDROID_USER_HOME`.

## User Review Required

> [!IMPORTANT]
> This fix involves modifying `gradle.properties` to explicitly set the preference location. If you prefer to fix this in your shell environment, you should unset `ANDROID_PREFS_ROOT` in your `.zshrc` or `.bash_profile`.

## Proposed Changes

### Build Configuration

#### [MODIFY] [gradle.properties](file:///Users/diluwar/development/care-sync-health/mobile/care-sync-mobile/gradle.properties)
- Add system properties to explicitly set `ANDROID_USER_HOME` and `ANDROID_PREFS_ROOT` to the same value, or attempt to override the environment variables by setting them to a consistent state that AGP expects.
- Actually, the most robust way within the project is to set `systemProp.ANDROID_USER_HOME` to the current user's `.android` directory. However, since I can't easily resolve the home directory in `gradle.properties` dynamically, I will use a relative path if possible or suggest the environment fix.
- Wait, I can use `settings.gradle.kts` to programmatically handle this before plugins are applied.

#### [MODIFY] [settings.gradle.kts](file:///Users/diluwar/development/care-sync-health/mobile/care-sync-mobile/settings.gradle.kts)
- Add a workaround to clear or unify the system properties if both are present.

## Verification Plan

### Automated Tests
- Run `./gradlew :shared:compileAndroidMain` to verify the build succeeds.

### Manual Verification
- Verify that the "Daemon terminated unexpectedly" error no longer appears.
