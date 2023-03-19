public class KontoBankowe {
    private String nazwaBanku;
    private Long numer;
    private String pesel;
    private Double depozyt;
    private Long licznikOperacji;
    private Long licznikWyplat;

    public KontoBankowe(String nazwaBanku, Long numer, String pesel) {
        this.nazwaBanku = nazwaBanku;
        this.numer = numer;
        this.pesel = pesel;
        this.depozyt = 0d;
        this.licznikOperacji = 0L;
        this.licznikWyplat = 0L;
    }

    public void wplac(Double wplata) {
        if (wplata <= 0) {
            return;
        }
        this.depozyt += wplata;
        this.licznikOperacji++;
    }

    public Double wyplac(Double wyplata) {
        if (this.depozyt < wyplata) {
            System.out.println("nie mozesz wyplacic wiecej niz masz");
            return null;
        }
        this.depozyt -= wyplata;
        this.licznikWyplat++;
        this.licznikOperacji++;
        return wyplata;
    }


    public void przelew(KontoBankowe to, Double kwota) {
        if (this.depozyt < kwota) {
            System.out.println("nie mozesz przelac wiecej niz masz");
            return;
        }
        this.depozyt -= kwota;
        to.depozyt += kwota;
        this.licznikOperacji++;
    }


    public String getNazwaBanku() {
        return nazwaBanku;
    }

    public void setNazwaBanku(String nazwaBanku) {
        this.nazwaBanku = nazwaBanku;
    }

    public Long getNumer() {
        return numer;
    }

    public void setNumer(Long numer) {
        this.numer = numer;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Long getLicznikOperacji() {
        return licznikOperacji;
    }

    public void setLicznikOperacji(Long licznikOperacji) {
        this.licznikOperacji = licznikOperacji;
    }

    public Long getLicznikWyplat() {
        return licznikWyplat;
    }

    public void setLicznikWyplat(Long licznikWyplat) {
        this.licznikWyplat = licznikWyplat;
    }

    public Double getDepozyt() {
        return depozyt;
    }

    public void setDepozyt(Double depozyt) {
        this.depozyt = depozyt;
    }

    @Override
    public String toString() {
        return "KontoBankowe{" +
                "nazwaBanku='" + nazwaBanku + '\'' +
                ", numer=" + numer +
                ", pesel='" + pesel + '\'' +
                ", depozyt=" + depozyt +
                ", licznikOperacji=" + licznikOperacji +
                ", licznikWyplat=" + licznikWyplat +
                '}';
    }
}
