using Ligen.Services;
using Spectre.Console;

namespace Ligen.Controllers;

public static class ParseController
{
    public static string ParseTemplate(string license)
    {
        return license switch
        {
            "mit" => Mit(),
            "apache2" => Apache2(),
            "bsl" => Bsl(),
            "mozilla2" => Mozilla2(),
            "gpl3" => Gpl3(),
            "lgpl3" => Lgpl3(),
            "agpl3" => Agpl3(),
            "unlicense" => Unlicense(),
            _ => ""
        };
    }

    private static string Mit()
    {
        string name = AnsiConsole.Ask<string>("Enter your [blue]name[/]: ");
        string year = AnsiConsole.Ask<string>("Enter the [blue]year[/]: ", DateTime.Now.Year.ToString());
        
        string template = FileService.GetTemplate("mit");
        
        return ParseService.Parse(template)
            .Name(name)
            .Year(year)
            .Build();
    }
    
    private static string Apache2()
    {
        string name = AnsiConsole.Ask<string>("Enter your [blue]name[/]: ");
        string year = AnsiConsole.Ask<string>("Enter the [blue]year[/]: ", DateTime.Now.Year.ToString());
        
        string template = FileService.GetTemplate("apache2");
        
        return ParseService.Parse(template)
            .Name(name)
            .Year(year)
            .Build();
    }
    
    private static string Bsl()
    {
        return FileService.GetTemplate("bsl");
    }
    
    private static string Mozilla2()
    {
        return FileService.GetTemplate("mozilla2");
    }
    
    private static string Gpl3()
    {
        string name = AnsiConsole.Ask<string>("Enter your [blue]name[/]: ");
        string year = AnsiConsole.Ask<string>("Enter the [blue]year[/]: ", DateTime.Now.Year.ToString());
        string description = AnsiConsole.Ask<string>("Enter a [blue]description[/]: ");
        string program = AnsiConsole.Ask<string>("Enter the [blue]program name[/]: ");
        
        string template = FileService.GetTemplate("gpl3");
        
        return ParseService.Parse(template)
            .Name(name)
            .Year(year)
            .Description(description)
            .Program(program)
            .Build();
    }
    
    private static string Lgpl3()
    {
        return FileService.GetTemplate("lgpl3");
    }
    
    private static string Agpl3()
    {
        string name = AnsiConsole.Ask<string>("Enter your [blue]name[/]: ");
        string year = AnsiConsole.Ask<string>("Enter the [blue]year[/]: ", DateTime.Now.Year.ToString());
        string description = AnsiConsole.Ask<string>("Enter a [blue]description[/]: ");
        
        string template = FileService.GetTemplate("agpl3");
        
        return ParseService.Parse(template)
            .Name(name)
            .Year(year)
            .Description(description)
            .Build();
    }

    private static string Unlicense()
    {
        return FileService.GetTemplate("unlicense");
    }
}