package EasyKit;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

// Easy UI effects.
public class Ui {
    
    private static Panel Main;
    
    public static enum textFieldType 
    {
        NumberOnly,
        NumberRange,
        Text,
        TextLimit
    }
    
    private static class TextFieldSettings 
    {
        JTextField selectedTextField;
        textFieldType currentType;
        
        String DefaultText;
        String DefaultName;
        Color BackgroundColor;
        
        boolean AllowResize = false;
        
        Rectangle Bounds;
        
        Color UnselectedTextColor;
        Color SelectedTextColor;
        
        int MaxLength = -1; // New field for text limit
        double MinValue = Double.MIN_VALUE; // New field for number range
        double MaxValue = Double.MAX_VALUE; // New field for number range
        
        TextFieldSettings(JTextField selected, textFieldType Type, Color SelectedTextColor, boolean AllowResize) 
        {
            selectedTextField = selected;
            currentType = Type;
            this.AllowResize = AllowResize;
            Bounds = selected.getBounds();
            this.SelectedTextColor = SelectedTextColor;
            SetupValues();
        }
        
        void SetupValues() 
        {
            DefaultText = selectedTextField.getText();
            DefaultName = selectedTextField.getName();
            BackgroundColor = selectedTextField.getBackground();
            UnselectedTextColor = selectedTextField.getForeground();
        }
    }
    
    public static List<TextFieldSettings> TextFields = new ArrayList<>();
    
    public static void UiSetup(Panel MainFrame) 
    {
        Main = MainFrame;
        Main.requestFocusInWindow();
    }
    
    public static void TextFieldSetup(JTextField TextUi, textFieldType Type, Color SelectedTextColor, boolean AllowResize) 
    {
        TextFieldSettings NewTextUi = new TextFieldSettings(TextUi, Type, SelectedTextColor, AllowResize);
        TextFields.add(NewTextUi);
    }
    
    // New method to set text limit for TextLimit type
    public static void SetTextLimit(JTextField TextUi, int maxLength) {
        for (TextFieldSettings settings : TextFields) {
            if (settings.selectedTextField == TextUi && settings.currentType == textFieldType.TextLimit) {
                settings.MaxLength = maxLength;
                return;
            }
        }
        System.out.println("TextField not found or not of TextLimit type.");
    }
    
    // New method to set number range for NumberRange type
    public static void SetNumberRange(JTextField TextUi, double minValue, double maxValue) {
        for (TextFieldSettings settings : TextFields) 
        {
            if (settings.selectedTextField == TextUi && settings.currentType == textFieldType.NumberRange) 
            {
                settings.MinValue = minValue;
                settings.MaxValue = maxValue;
                return;
            }
        }
        
        System.out.println("TextField not found or not a NumberRange type.");
    }
    
    public static void focusChange(JComponent UiObject) {
        if (UiObject != null) 
        {
            UiObject.requestFocusInWindow();
        } 
        else 
        {
            System.out.println("Unfocused");
            Main.requestFocusInWindow();
        }
    }
    
    public static void toggleTipText(JTextField TextUi) 
    {
        TextFieldSettings GotTextUi = null;
        for (TextFieldSettings settings : TextFields) 
        {
            if (settings.selectedTextField == TextUi) 
            {
                GotTextUi = settings;
                break;
            }
        }
        
        if (GotTextUi == null) 
        {
            System.out.println("Not in system.");
            return;
        }
        
        String text = TextUi.getText();
        boolean focused = TextUi.hasFocus();
        
        if (focused) 
        {
            handleFocusedState(TextUi, GotTextUi, text);
        }
        else 
        {
            handleUnfocusedState(TextUi, GotTextUi, text);
        }
    }
    
    private static void handleFocusedState(JTextField TextUi, TextFieldSettings GotTextUi, String text) {
        if (text.equals(GotTextUi.DefaultText) || text.equals("Null")) 
        {
            TextUi.setText("");
        }
        resizeTextField(TextUi, GotTextUi);
        TextUi.setForeground(GotTextUi.SelectedTextColor);
        
        // used based on the text field type where it will use different text effects
        switch (GotTextUi.currentType) 
        {
            case NumberOnly:
                enforceNumberOnly(TextUi);
                break;
            case NumberRange:
                enforceNumberRange(TextUi, GotTextUi);
                break;
            case TextLimit:
                enforceTextLimit(TextUi, GotTextUi);
                break;
            default:
                break;
        }
    }
    
    private static void handleUnfocusedState(JTextField TextUi, TextFieldSettings GotTextUi, String text) {
        if (text.equals("")) 
        {
            TextUi.setText(GotTextUi.DefaultText);
            TextUi.setBounds(GotTextUi.Bounds);
        }
        else 
        {
            resizeTextField(TextUi, GotTextUi);
        }
        TextUi.setForeground(GotTextUi.UnselectedTextColor);
    }
    
    private static void resizeTextField(JTextField TextUi, TextFieldSettings GotTextUi) {
        if (GotTextUi.AllowResize) 
        {
            int width;
            if (TextUi.getText().length() > 1) 
            {
                width = 11 * TextUi.getText().length();
            }
            else 
            {
                width = TextUi.getText().equals("0") ? 14 : 9;
            }
            TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, width, TextUi.getBounds().height);
        }
    }
    
    private static void enforceNumberOnly(JTextField TextUi) // Forces the text to only be numbers
    {
        String text = TextUi.getText();
        
        if (!text.matches("\\d*")) 
        {
            TextUi.setText(text.replaceAll("[^\\d]", ""));
        }
    }
    
    private static void enforceNumberRange(JTextField TextUi, TextFieldSettings GotTextUi) 
    {
        try 
        {
            double value = Double.parseDouble(TextUi.getText());
            if (value < GotTextUi.MinValue) 
            {
                TextUi.setText(String.valueOf(GotTextUi.MinValue));
            } 
            else if (value > GotTextUi.MaxValue) 
            {
                TextUi.setText(String.valueOf(GotTextUi.MaxValue));
            }
        } 
        catch (NumberFormatException e) 
        {
            TextUi.setText(String.valueOf(GotTextUi.MinValue));
        }
    }
    
    private static void enforceTextLimit(JTextField TextUi, TextFieldSettings GotTextUi) 
    {
        if (GotTextUi.MaxLength > 0 && TextUi.getText().length() > GotTextUi.MaxLength) 
        {
            TextUi.setText(TextUi.getText().substring(0, GotTextUi.MaxLength));
        }
    }
    
    public static void getTextFieldSettings(JTextField TextUi) 
    {
    	
    	return null;
    }
}