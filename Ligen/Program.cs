using Ligen.Controllers;
using Ligen.Services;
using Spectre.Console;

LicenseController licenseController = new LicenseController();

var choice = AnsiConsole.Prompt(
    new SelectionPrompt<string>()
        .Title("[bold green]Select an option:[/]")
        .HighlightStyle(new Style(Color.Blue, null, Decoration.Bold))
        .AddChoices("Generate Licence", "About Licenses")
    );

if (choice == "About Licenses")
{
    licenseController.LicenceInfo();
    return 0;
}

string license = licenseController.AskLicense();
string template = ParseController.ParseTemplate(license);

var outputPath = Environment.CurrentDirectory;

string filePath = FileService.WriteFile(template, outputPath);

var message = new Panel(new TextPath(filePath))
    .Header("[bold green]License Generated at[/]");

AnsiConsole.Write(message);
return 0;