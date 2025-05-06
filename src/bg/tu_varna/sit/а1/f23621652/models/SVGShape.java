package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.interfaces.Pointer;

import java.util.Objects;

public abstract class SVGShape implements Pointer {
    private String fill = "black";
    private String stroke = "black";

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!this.fill.equals("black")){
            sb.append(", fill=").append(fill);
        }
        if(!this.stroke.equals("black")){
            sb.append(", stroke=").append(stroke);
        }
        return sb.toString();
    }
}
