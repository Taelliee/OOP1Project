package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.interfaces.Pointer;

public abstract class SVGShape implements Pointer {
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
