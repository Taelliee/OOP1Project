package bg.tu_varna.sit.а1.f23621652.models;

public abstract class SVGShape {
    private String fill = "black";
    private String style;

    public String getFill() {
        return fill;
    }

    public String getStyle() {
        return style;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.fill != "black"){
            sb.append(", fill=").append(fill);
        }
        if (this.style != null) {
            sb.append(", style=").append(style);
        }
        return sb.toString();
    }
}
