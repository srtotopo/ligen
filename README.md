# ligen

`ligen` is a lightweight command-line utility to quickly generate software license files from your terminal.

It is designed for developers who want a fast and simple way to add standard licenses to their projects without leaving the command line.

This project is primarily intended to be built and distributed as a native executable using GraalVM Native Image.

## Features

- Fast and minimal command-line workflow
- Native binary target for quick startup and low runtime footprint
- Generates common open-source licenses
- Optional fields for project and author metadata
- Output customization for file name/path

## Supported Licenses

`ligen` currently includes templates for:

- MIT
- Apache 2.0
- BSD (BSL)
- Mozilla Public License 2.0
- GPLv3
- LGPLv3
- AGPLv3
- Unlicense

## Requirements

- GraalVM with Native Image support
- Gradle Wrapper (included in this repository)

## Installation

### Clone the repository

```bash
git clone https://github.com/srtotopo/ligen.git
cd ligen
```

## Build

Build project artifacts:

```bash
./gradlew build
```

Compile the native binary (GraalVM Native Image via Gradle):

```bash
./gradlew nativeCompile
```

From the current project structure, the native executable is generated at:

`build/native/nativeCompile/ligen`

## Usage

Show help:

```bash
ligen --help
```

Generate a Mozilla Public License license:

```bash
ligen mozilla
```

Generate an Apache 2.0 license with metadata:

```bash
ligen apache --name "John Doe" --year 2024
```

Write output to a specific file:

```bash
ligen bsl --output LICENSE
```

## Project Structure

- `src/main/java/` - application source code
- `src/main/resources/templates/` - license templates
- `src/test/` - tests
- `build.gradle.kts` - Gradle build configuration

## Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a Pull Request

Please keep changes focused, documented, and tested when applicable.