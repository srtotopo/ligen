using Ligen.Controllers;
using Spectre.Console;

LicenseController licenseController = new LicenseController();

var license = licenseController.AskLicense();
    
AnsiConsole.MarkupLine($"[green bold]You selected:[/] [blue bold]{license}[/]");