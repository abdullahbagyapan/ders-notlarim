// İlan listesi sınıfı. Sadece belirtilen satırdan sonra değişiklik yapınız
// İstisna olarak üste import ifadeleri eklenebilir.
public class IlanListesi {
    // İlan listesini tutan değişken, dışarda oluşturulup constructor ile atanır.
    private DoublyLinkedList<IsIlani> ilanlar;
    public DoublyLinkedList<IsIlani> getIlanlar() {
        return ilanlar;
    }
    public IlanListesi(DoublyLinkedList<IsIlani> ilanlar) {
        this.ilanlar = ilanlar;
    }
    // Bu satırdan itibaren değişiklik yapabilirsiniz, metod imzalarını değiştirmeyiniz.
    /**
     * Aktif ilanlar arasında ücreti en büyük ilanı döndüren metot
     * Çok düşük bir ihtimalle aynı ücrete sahip olan birden fazla ilan bulunabilir. Bu durumda testi tekrar
     * çalıştırın lütfen.
     *
     * @return Ücreti en büyük aktif ilan
     */
    public IsIlani enBuyukUcretliAktifIlan() {
        return null;
    }
    /**
     * İş tanımı içinde aranan sözcüğün kaç ilanda geçtiğini veren metot
     *
     * @param arananSozcuk Aranan sözcük
     * @return Aranan sözcüğün geçtiği ilan sayısı
     */
    public int isTanimindaSozcukGecenIlanSayisi(String arananSozcuk) {
        return -1;
    }
    /**
     * İş süreleri küçükten büyüğe sıralandığında k. sırada olan işin süresini veren metot,
     * başka bir deyişle k. en küçük iş süresi
     * Örneğin iş süreleri 6,3,11,2,14,8 ve k=3 olsun, geri dönüş değeri 6 olacaktır.
     *
     * @param k En küçük kaçıncı değerin istediğini belirten parametre
     * @return İş süreleri küçükten büyüğe sıralandığında k. sırada olan işin süresi
     */
    public int isSuresiEnAzKinciIsinSuresi(int k) {
        return -1;
    }

    /**
     * Her bir kategorideki ilanlardaki ücretler toplanarak, toplam ücreti en çok olan kategori ismi döndürülmelidir
     * Problemin kolay çözümü için Map arayüzünü ve HashMap sınıfının kullanımını inceleyebilirsiniz
     *
     * @return İçindeki ilanların ücret toplamı en çok olan kategori
     */
    public String ucretToplamiEnBuyukKategori() {
        return null;
    }
}
