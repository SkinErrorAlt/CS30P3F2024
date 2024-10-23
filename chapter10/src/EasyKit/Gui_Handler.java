package EasyKit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class Gui_Handler {

    public static class CreateTextField {
    	
    	
        private Map<TextFieldSettings, List<Object>> textSettings = new HashMap<>(); // Instead of using an array i'm using a hashmap because its easier and wayyyy faster since i looks for the value directly instead of checking every single one.

        public void createTextField(TextFieldSettings... settings) // Gets a list of TextFieldSettings enum.
        {
            for (TextFieldSettings setting : settings) // Loops through all settings aka the enums.
            {
                textSettings.put(setting, new ArrayList<>()); // Puts it in the hash map.
            }
        }

        public void addSetting(TextFieldSettings setting, Object... values) // This function just gets a TextFieldSettings enum and then gets a list of Objects that i can use for the settings of it.
        {
            if (textSettings.containsKey(setting)) 
            {
                for (Object value : values) 
                {
                    textSettings.get(setting).add(value);
                }
            } 
            else 
            {
                Console.error("Create TextField Settings", "Setting not found: " + setting, false);
            }
        }

        public List<Object> getSettings(TextFieldSettings setting) 
        {
            return textSettings.getOrDefault(setting, Collections.emptyList());
        }
    }

    public static enum TextFieldSettings 
    {
        Number_Only,
        Number_Range,
        Letter_Only,
        Limited_Char
    }

    public static void main(String[] args) 
    {
        CreateTextField textField = new CreateTextField();
        textField.createTextField(TextFieldSettings.Number_Only, TextFieldSettings.Number_Range);

        // Adding settings
        textField.addSetting(TextFieldSettings.Number_Only);
        textField.addSetting(TextFieldSettings.Number_Range, 0, 200);
        textField.addSetting(TextFieldSettings.Limited_Char, 0, 10);

        // Retrieving settings
        List<Object> numberOnlySettings = textField.getSettings(TextFieldSettings.Number_Only);
        List<Object> numberRangeSettings = textField.getSettings(TextFieldSettings.Number_Range);
        List<Object> letterRangeSettings = textField.getSettings(TextFieldSettings.Limited_Char);

        System.out.println("Number Only Settings: " + numberOnlySettings); // Output: Number Only Settings: []
        System.out.println("Number Range Settings: " + numberRangeSettings); // Output: Number Range Settings: [0, 200]
        System.out.println("Number Range Settings: " + letterRangeSettings); // Output: Number Range Settings: [0, 200]
    }
}
