import java.util.Scanner;

public class TemperatureConverter 
{
    public static double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9 / 5) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double celsiusToKelvin(double celsius)
    {
        return celsius + 273.15;
    }
    public static double fahrenheitToKelvin(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }
    public static double kelvinToCelsius(double kelvin) 
    {   
        return kelvin - 273.15;
    }
    public static double kelvinToFahrenheit(double kelvin)
    {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
    public static double convertTemperature(double value, String fromUnit, String toUnit) 
    {
        if (fromUnit.equalsIgnoreCase("Celsius")) 
        {
            if (toUnit.equalsIgnoreCase("Fahrenheit")) 
                return celsiusToFahrenheit(value);
            else if (toUnit.equalsIgnoreCase("Kelvin")) 
                return celsiusToKelvin(value);
        
        } 
        else if (fromUnit.equalsIgnoreCase("Fahrenheit")) 
        {
            if (toUnit.equalsIgnoreCase("Celsius")) 
                return fahrenheitToCelsius(value);
            else if (toUnit.equalsIgnoreCase("Kelvin")) 
                return fahrenheitToKelvin(value);
            
        } 
        else if (fromUnit.equalsIgnoreCase("Kelvin")) 
        {
            if (toUnit.equalsIgnoreCase("Celsius")) 
                return kelvinToCelsius(value);
            else if (toUnit.equalsIgnoreCase("Fahrenheit")) 
                return kelvinToFahrenheit(value);
        }
        return value;  // Return the value unchanged if units are the same
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("=====================");
        System.out.println("Supported units: Celsius, Fahrenheit, Kelvin");
        System.out.println();
        char ch;
        do
        {
        System.out.print("Enter temperature value: ");
        double value = scanner.nextDouble();
        scanner.nextLine();  // Consume newline character

        System.out.print("Enter source temperature unit: ");
        String fromUnit = scanner.nextLine();

        System.out.print("Enter target temperature unit: ");
        String toUnit = scanner.nextLine();

        double result = convertTemperature(value, fromUnit, toUnit);
        System.out.printf("%.2f %s is equal to %.2f %s%n", value, fromUnit, result, toUnit);
        System.out.println();
        
        System.out.println("DO YOU WANT TO CONTINUE");
        System.out.println("ENTER 'y' FOR YES AND 'n' FOR NO");
        ch=scanner.next().charAt(0);
        }
        while(ch=='y');
        scanner.close();
    }
}
