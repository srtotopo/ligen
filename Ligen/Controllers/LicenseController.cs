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

    private readonly Dictionary<string, string> _licenseInfo = new()
    {
        { "MIT", "A short, permissive license that allows almost anything. It only requires preserving the original copyright and license notice, and provides no liability." },
        { "Apache 2.0", "A permissive license that includes an express grant of patent rights. It allows commercial use and modification, provided copyright and notices are preserved." },
        { "BSD (BSL)", "A highly permissive license with minimal restrictions. It allows redistribution and use in source and binary forms, provided the copyright notice is retained." },
        { "Mozilla Public License 2.0", "A weak copyleft license. Modifications to the original source files must be released under MPL, but they can be combined with proprietary code." },
        { "GPLv3", "A strong copyleft license. It requires that any modified versions or derived works must also be distributed under the GPLv3, and includes patent protections." },
        { "LGPLv3", "A copyleft license primarily for libraries. It allows the library to be linked with proprietary software, but modifications to the library itself must remain open." },
        { "AGPLv3", "A strict copyleft license designed for network software. It ensures that if the software is run as a service over a network, the source code must be shared with users." },
        { "Unlicense", "A complete public domain dedication. The author waives all copyright, allowing anyone to use, modify, or distribute the software for any purpose with no conditions." }
    };

    public License AskLicense()
    {
        var choise = AnsiConsole.Prompt(
            new SelectionPrompt<string>()
                .Title("[bold green]Select a license:[/]")
                .HighlightStyle(new Style(Color.Blue, null, Decoration.Bold))
                .AddChoices(_licenses.Keys)
        );
        
        return _licenses[choise];
    }

    public void LicenceInfo()
    {
        var infoTable = new Table()
            .AddColumn("[bold green]License[/]", col => col.Width(20))
            .AddColumn("[bold green]Description[/]", col => col.Width(80))
            .ShowRowSeparators()
            .RoundedBorder();

        foreach (var licenseInfo in _licenseInfo)
        {
            infoTable.AddRow($"[bold blue]{licenseInfo.Key}[/]", licenseInfo.Value);
        }
        
        AnsiConsole.Write(infoTable);
    }
}