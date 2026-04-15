using Spectre.Console;

namespace Ligen.Controllers;

public class LicenseController
{
    private readonly Dictionary<string, License> _licenses = new()
    {
        { "MIT", License.MIT },
        { "Apache 2.0", License.APACHE2 },
        { "BSD (BSL)", License.BSD },
        { "Mozilla Public License 2.0", License.MPL2 },
        { "GPLv3", License.GPL3 },
        { "LGPLv3", License.LGPL3 },
        { "AGPLv3", License.AGPL3 },
        { "Unlicense", License.UNLICENSE }
    };

    public License AskLicense()
    {
        var choise = AnsiConsole.Prompt(
            new SelectionPrompt<string>()
                .Title("[bold]Select a license:[/]")
                .HighlightStyle(new Style(Color.Blue, null, Decoration.Bold))
                .AddChoices(_licenses.Keys)
        );
        
        return _licenses[choise];
    }
}