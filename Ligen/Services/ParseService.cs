namespace Ligen.Services;

public class ParseService
{
    private readonly string _content;
    private readonly Dictionary<string, string> _replacements;
    
    private ParseService(string content)
    {
        _content = content;
        _replacements = new Dictionary<string, string>();
    }

    public static ParseService Parse(string content)
    {
        return new ParseService(content);
    }

    public ParseService Name(string name)
    {
        if (string.IsNullOrEmpty(name))
        {
            throw new ArgumentException("Name cannot be null or empty.", nameof(name));
        }
        
        _replacements["name"] =  name;
        return this;
    }
    
    public ParseService Year(string year)
    {
        if (string.IsNullOrEmpty(year))
        {
            throw new ArgumentException("Year cannot be null or empty.", nameof(year));
        }
        
        _replacements["year"] =  year;
        return this;
    }

    public ParseService Description(string description)
    {
        if (string.IsNullOrEmpty(description))
        {
            throw new ArgumentException("Description cannot be null or empty.", nameof(description));
        }
        
        _replacements["description"] =  description;
        return this;
    }

    public ParseService Program(string program)
    {
        if (string.IsNullOrEmpty(program))
        {
            throw new ArgumentException("Program cannot be null or empty.", nameof(program));
        }
        
        _replacements["program"] =  program;
        return this;
    }
    
    public string Build()
    {
        var result = _content;
        
        foreach (var replacement in _replacements)
        {
            result = result.Replace("{{" + replacement.Key + "}}", replacement.Value);
        }
        
        return result;
    }
}