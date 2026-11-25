# LUNEX — SA-MP Launcher

LUNEX is an Android SA-MP launcher project based on the OpenSAMPLauncher codebase.

## Included
- Dark launcher interface with server IP, port, password, and server information.
- Nickname and ping-timeout preferences.
- Server information lookup and ping status components.
- SA-MP APK/cache installer UI and download/extraction pipeline inherited from upstream.
- Defensive handling for invalid server input and malformed saved preferences.

## Build
1. Open the project in Android Studio.
2. Use JDK 8 with the checked-in Gradle wrapper (Gradle 6.5) and Android Gradle Plugin 4.1.1.
3. Install Android SDK Platform 29 and Build Tools 30.0.3.
4. Sync Gradle, then run the `app` configuration.

The project intentionally retains its legacy Android/Kotlin toolchain to avoid an unverified migration. The build must be validated in an environment that can download the Gradle distribution and Maven dependencies.

## Known limitations
- The real SA-MP client launch flow is not implemented; the Play action displays a notice instead of claiming to launch the game.
- The server-list screen is not implemented yet; server configuration persistence exists but is not connected to a complete browser UI.
- Installer URLs and storage behavior are inherited from upstream and must be reviewed before production use.
- This repository does not include a signing keystore or machine-specific `local.properties`. Configure your own release signing credentials locally.

## Project details
- Application ID: `com.umnicode.samp_launcher`
- Target SDK: 29
- Minimum SDK: 16
