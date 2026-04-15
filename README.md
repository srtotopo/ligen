# Ligen

Ligen is a small interactive CLI tool that helps you generate a `LICENSE` file for your project.

It uses built-in templates and a guided prompt flow in the terminal.

## Features

- Interactive terminal UI powered by Spectre.Console
- Generate a `LICENSE` file in the current working directory
- Show quick descriptions of available licenses (`About Licenses` option)
- Supports placeholder replacement for templates that require author/project data

## Requirements

- .NET SDK compatible with target framework `net10.0`

## Run

From the repository root:

```bash
dotnet run --project Ligen/Ligen.csproj
```

The app will ask you to:

1. Select an option (`Generate Licence` or `About Licenses`)
2. If generating, choose a license template
3. Fill requested fields (name, year, description, program name when required)

After generation, the tool writes a `LICENSE` file to your current directory.

## Supported Licenses

- MIT
- Apache 2.0
- BSD (BSL)
- Mozilla Public License 2.0
- GPLv3
- LGPLv3
- AGPLv3
- Unlicense

## Project Structure

- `Ligen/Program.cs`: CLI entrypoint and menu flow
- `Ligen/Controllers/`: user interaction and template selection
- `Ligen/Services/`: template loading, placeholder parsing, and file writing
- `Ligen/Templates/`: embedded license templates

## Contributing

Contributions are welcome. Feel free to open an issue or submit a pull request.

## License

This repository currently includes a `LICENSE` file at the root.
