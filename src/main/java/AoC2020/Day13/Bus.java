package AoC2020.Day13;

public class Bus {

    private int modulo;

    private long Xi;
    private long Bi;
    private long Ni;

    public Bus() {
    }

    public Bus(int modulo) {
        this.modulo = modulo;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public Long getXi() {
        return Xi;
    }

    public void setXi(Long xi) {
        Xi = xi;
    }

    public Long getBi() {
        return Bi;
    }

    public void setBi(int bi) {
        Bi = bi;
    }

    public Long getNi() {
        return Ni;
    }

    public void setNi(Long ni) {
        Ni = ni;
    }

    public Long getBiNiXi() {
        return Bi * Ni * Xi;
    }
}
