using System.Reflection;
using System.Text;

namespace Ligen.Services;

public static class FileService
{
    public static string GetTemplate(string templateName)
    {
        var assembly = Assembly.GetExecutingAssembly();
        var resourceName = $"Ligen.Templates.{templateName.ToLower()}.txt";
        
        using Stream? stream = assembly.GetManifestResourceStream(resourceName);

        if (stream == null)
        {
            throw new FileNotFoundException($"Template '{templateName}' not found as an embedded resource.");
        }
        
        using StreamReader reader = new StreamReader(stream, Encoding.UTF8);
        return reader.ReadToEnd();
    }

    public static void WriteFile(string content, string outputPath)
    {
        try
        {
            Directory.CreateDirectory(outputPath);
            string filePath = Path.Combine(outputPath, "LICENSE");
            
            File.WriteAllText(filePath, content, Encoding.UTF8);
        }
        catch (Exception e)
        {
            throw new IOException($"Failed to write file to: {outputPath}", e);
        }
    }
}