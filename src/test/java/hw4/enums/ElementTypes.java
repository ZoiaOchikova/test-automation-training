package hw4.enums;

public enum ElementTypes {

    RADIO("radio"),
    CHECKBOX("checkbox"),
    DROPDOWN("dropdown");

    final String type;

    ElementTypes(String type){ this.type = type;}

    public String getType() {
        return type;
    }
}
