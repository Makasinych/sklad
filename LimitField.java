package swing2;

import javax.swing.* ;
import javax.swing.text.* ;
import java.awt.* ;
@SuppressWarnings("serial")
public class LimitField extends JTextField
{
   //лимит ввода символов в поля JTextField, код класса взят с форума
    private int maximum ;
    
    public LimitField(int columns, int max)
    {
        super(columns);
        maximum = max ;
    }
    
    public LimitField( String text, int columns, int max )
    {
        super(text, columns);
        maximum = max;
    }
   
    protected Document createDefaultModel()
    {
        return new LimitDocument();
    }
    
    private class LimitDocument extends PlainDocument
    {
        public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException
        {
            StringBuffer buffer = new StringBuffer(getText(0, getLength()));
            if((buffer.length() + str.length()) <= maximum ){
            	super.insertString(offs, str, a);
            }else{
            	Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}