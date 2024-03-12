public class Field{
    Field parentField;
    Position position;
    private int costToStart = 0;
    private int heuristik = 0;
    private final fieldType type;


    public Field(Field parentField, Position position, fieldType type){
        this.parentField = parentField;
        this.position = position;
        this.type = type;

    }

    public Position getPosition() {
        return position;
    }

    public Field getParentField() {
        return parentField;
    }

    public int getCostToStart() {
        return costToStart;
    }

    public int getHeuristik() {
        return heuristik;
    }

    public void setCostToStart(int costToStart) {
        this.costToStart = costToStart;
    }

    public void setHeuristik(int heuristik) {
        this.heuristik = heuristik;
    }

    public int getFieldCost(){
        return heuristik + costToStart;
    }

    public fieldType getType() {
        return type;
    }
    public byte getVal(){
        return (byte) type.ordinal();
    }
}