package it.overzoom.postway.model;

public class Price {
    private Double tot;
    private Double net;
    private Double tax;
    private String cur;

    public Double getTot() {
        return tot;
    }

    public void setTot(Double tot) {
        this.tot = tot;
    }

    public Double getNet() {
        return net;
    }

    public void setNet(Double net) {
        this.net = net;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }
}
