using Ligen.Controllers;
using Spectre.Console;

LicenseController licenseController = new LicenseController();

var choice = AnsiConsole.Prompt(
    new SelectionPrompt<string>()
        .Title("\nSelect an option:")
        .HighlightStyle(new Style(Color.Green, null, Decoration.Bold))
        .AddChoices("Generate Licence", "About Licenses")
    );

if (choice == "About Licenses")
{
    licenseController.LicenceInfo();
    return 0;
}

var license = licenseController.AskLicense();
AnsiConsole.MarkupLine($"[green bold]You selected:[/] [blue bold]{license}[/]");
return 0;