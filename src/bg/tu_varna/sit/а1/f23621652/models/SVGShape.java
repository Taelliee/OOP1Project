package bg.tu_varna.sit.а1.f23621652.models;

public abstract class SVGShape {
    private String fill = "black";

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.fill != "black"){
            sb.append(", fill=").append(fill);
        }
        return sb.toString();
    }
}
