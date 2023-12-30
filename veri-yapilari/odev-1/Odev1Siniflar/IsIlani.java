/**
 * IsIlani sınıfı iş ilanlarının bilgisini saklamak için kullanılır
 */
public class IsIlani {
    // İş açıklaması
    private String isTanimi;
    public String getIsTanimi() {
        return isTanimi;
    }
    // İş kategorisi
    private String kategori;
    public String getKategori() {
        return kategori;
    }
    // İşin ücreti
    private double ucret;
    public double getUcret() {
        return ucret;
    }
    // İşin kaç gün süreceği
    private int isSuresi;
    public int getIsSuresi() {
        return isSuresi;
    }
    // İşin aktiflik durumu, false ise iş yayında değil
    private boolean aktif;
    public boolean isAktif() {
        return aktif;
    }
    // Constructor
    public IsIlani(String isTanimi, String kategori, double ucret, int isSuresi, boolean aktif) {
        this.isTanimi = isTanimi;
        this.kategori = kategori;
        this.ucret = ucret;
        this.isSuresi = isSuresi;
        this.aktif = aktif;
    }
    // Alttaki metotlar testlerin çalışması ve yazdırma işlemleri için kullanılmaktadır,
    // kullanmanız ya da öğrenmeniz zorunlu değildir.
    @Override
    public String toString() {
        return "IsIlani [isTanimi=" + isTanimi + ", kategori=" + kategori + ", ucret=" + ucret + ", isSuresi="
                + isSuresi + ", aktif=" + aktif + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isTanimi == null) ? 0 : isTanimi.hashCode());
        result = prime * result + ((kategori == null) ? 0 : kategori.hashCode());
        long temp;
        temp = Double.doubleToLongBits(ucret);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + isSuresi;
        result = prime * result + (aktif ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IsIlani other = (IsIlani) obj;
        if (isTanimi == null) {
            if (other.isTanimi != null)
                return false;
        } else if (!isTanimi.equals(other.isTanimi))
            return false;
        if (kategori == null) {
            if (other.kategori != null)
                return false;
        } else if (!kategori.equals(other.kategori))
            return false;
        if (Double.doubleToLongBits(ucret) != Double.doubleToLongBits(other.ucret))
            return false;
        if (isSuresi != other.isSuresi)
            return false;
        if (aktif != other.aktif)
            return false;
        return true;
    }
}
