public class Anomaly {
    private String name;
    private String buffedType;
    private String nerfedType;

    public String getName() {
        return name;
    }

    public String getBuffedType() {
        return buffedType;
    }

    public String getNerfedType() {
        return nerfedType;
    }

    public void setBuffedType(String buffedType) {
        this.buffedType = buffedType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNerfedType(String nerfedType) {
        this.nerfedType = nerfedType;
    }
}
