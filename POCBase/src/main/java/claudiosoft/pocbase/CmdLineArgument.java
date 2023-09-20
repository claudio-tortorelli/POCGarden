package claudiosoft.pocbase;

/**
 *
 * @author Claudio
 */
public class CmdLineArgument {

    private final String label;

    private String value = null;
    private int valueInt = Integer.MIN_VALUE;
    private int valueBool = Integer.MIN_VALUE;

    private final boolean required;

    public CmdLineArgument(String label) {
        this(label, "", false);
    }

    public CmdLineArgument(String label, Object defValue) {
        this(label, defValue, false);
    }

    public CmdLineArgument(String label, Object defValue, boolean required) {
        this.label = label;
        if (defValue.getClass().isInstance(String.class)) {
            this.value = (String) defValue;
        } else if (defValue.getClass().isInstance(Integer.class)) {
            this.valueInt = (int) defValue;
        } else if (defValue.getClass().isInstance(Boolean.class)) {
            this.valueBool = 0;
            if ((boolean) defValue) {
                this.valueBool = 1;
            }
        }
        this.required = required;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() throws POCException {
        if (value == null) {
            throw new POCException("invalid argument type string");
        }
        return value;
    }

    public int getValueInt() throws POCException {
        if (valueInt == Integer.MIN_VALUE) {
            throw new POCException("invalid argument type int");
        }
        return valueInt;
    }

    public boolean getValueBool() throws POCException {
        if (valueBool == Integer.MIN_VALUE) {
            throw new POCException("invalid argument type boolean");
        }
        if (valueBool == 1) {
            return true;
        }
        return false;
    }

    public void setValue(String val) {
        value = val;
    }

    public void setValueInt(int val) {
        valueInt = val;
    }

    public void setValueBool(boolean val) {
        if (val) {
            valueBool = 1;
        } else {
            valueBool = 0;
        }
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isMissing() {
        return required && !hasValue();
    }

    private boolean hasValue() {
        if (value == null && valueInt == Integer.MIN_VALUE && valueBool == Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

}
