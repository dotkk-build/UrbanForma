# UrbanForma

UrbanForma is a Minecraft content mod focused on urban building materials,
glass, lighting, roads, and related decorative blocks. The project is a
compatibility port of the original UrbanForma 1.20.1 content for Minecraft
1.21.1.

## Compatibility

The current public `main` branch targets:

- Minecraft 1.21.1
- NeoForge 21.1.234 or newer
- Java 21
- Mod ID: `urbanforma`
- Mod version: `1.1016+mc1.21.1`

The repository also retains a legacy branch named `1.20.1-Forge`. That branch
is separate from the current `main` branch and must not be used as the
compatibility declaration for this release.

## Installation

1. Install Minecraft 1.21.1.
2. Install NeoForge 21.1.234 or a newer compatible NeoForge version.
3. Run the game with Java 21.
4. Place the UrbanForma jar in the instance `mods` directory.
5. The mod metadata declares `urbanforma_neo` as a required dependency. Make
   sure that dependency is available in the instance when your modpack does
   not already provide it.

Use the same Minecraft, NeoForge, and Java versions for every mod in the
instance. The project does not include a bundled runtime, launcher, or game
directory.

## Building From Source

Install a JDK 21 distribution, then run the Gradle wrapper from the project
root:

```text
gradlew.bat build
```

On a POSIX shell, use:

```text
./gradlew build
```

The built jar is written to `build/libs/`. The wrapper and project metadata
are included so the build can be reproduced without a machine-specific Java
path in the repository configuration.

## Project Status

This repository is the public source release for the Minecraft 1.21.1
NeoForge port. It is provided as-is and does not claim that every feature of
the original content has reached feature-complete parity.

## License

UrbanForma is released under the MIT License. See [LICENSE](LICENSE).
