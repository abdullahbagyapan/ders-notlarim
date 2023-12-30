// İlan listesi sınıfı. Sadece belirtilen satırdan sonra değişiklik yapınız
// İstisna olarak üste import ifadeleri eklenebilir.

import java.util.*;

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

        DoublyLinkedList<IsIlani> jobList = getIlanlar();
        IsIlani greatestIncomeJob = jobList.getHead().value;

        for (IsIlani job:jobList) {

            if (job.getUcret() > greatestIncomeJob.getUcret()) {
                greatestIncomeJob = job;
            }

        }

        return greatestIncomeJob;
    }
    /**
     * İş tanımı içinde aranan sözcüğün kaç ilanda geçtiğini veren metot
     *
     * @param arananSozcuk Aranan sözcük
     * @return Aranan sözcüğün geçtiği ilan sayısı
     */
    public int isTanimindaSozcukGecenIlanSayisi(String arananSozcuk) {

        int result = 0;
        DoublyLinkedList<IsIlani> jobList = getIlanlar();

        for (IsIlani job:jobList) {

            if (job.getIsTanimi().contains(arananSozcuk)) {
                result++;
            }
        }

        return result;
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

        ArrayList<Integer> workTimeList = new ArrayList<>(); 
        DoublyLinkedList<IsIlani> jobList = getIlanlar();

        for (IsIlani job:jobList) {
            workTimeList.add(job.getIsSuresi());
        }
        
        Collections.sort(workTimeList, Comparator.naturalOrder());
        return workTimeList.get(k);
    }

    /**
     * Her bir kategorideki ilanlardaki ücretler toplanarak, toplam ücreti en çok olan kategori ismi döndürülmelidir
     * Problemin kolay çözümü için Map arayüzünü ve HashMap sınıfının kullanımını inceleyebilirsiniz
     *
     * @return İçindeki ilanların ücret toplamı en çok olan kategori
     */
    public String ucretToplamiEnBuyukKategori() {

        DoublyLinkedList<IsIlani> jobList = getIlanlar();
        SortedMap<Double,String> jobMap = new TreeMap<>();

        for (IsIlani job:jobList) {
            jobMap.put(job.getUcret(),job.getKategori());
        }

        return jobMap.get(jobMap.lastKey()); // natural order
    }
}
