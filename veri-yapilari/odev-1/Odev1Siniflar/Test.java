import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
// CSVReader sınıfı açık kaynak kodlu OpenCSV 3.8 kütüphanesinden alınmaktadır
import com.opencsv.CSVReader;
/**
 * Eğer mevcut IDE'nize kütüphaneyi dahil etmeyi bilmiyorsanız,
 * programı derlemek ve çalıştırmak için aşağıdaki adımlar izlenebilir
 *
 * Derleme: javac -cp ".:./opencsv-3.8.jar" Test.java
 * Çalıştırma: java -cp ".:./opencsv-3.8.jar" Test
 *
 * opencsv-3.8.jar dosyasının Test.java ve diğer java dosyaları ile
 * aynı klasörde olduğu varsayılmıştır.
 */
public class Test {
    // Rastgele sayı üreteci
    public static Random random = new Random();

    public static void main(String[] args) {
        // İlan dizisini rastgele oluştur, istenilirse elle de oluşturulabilir
        IsIlani[] isler = generateJobs(5, 10);
        // Bağlı listeyi oluştur
        DoublyLinkedList<IsIlani> bagliListe = new DoublyLinkedList<>();
        // İlanları bağlı listeye ekle
        for (IsIlani ilan : isler) {
            bagliListe.addLast(ilan);
        }
        IlanListesi ilanListesi = new IlanListesi(bagliListe);
        // Metotların hiçbiri yazılmadığı için aşağıdaki çıktılar anlamsız olacaktır
        System.out.println("enBuyukUcretliAktifIlan: " + ilanListesi.enBuyukUcretliAktifIlan());
        System.out.println("isTanimindaSozcukGecenIlanSayisi: " + ilanListesi.isTanimindaSozcukGecenIlanSayisi("and"));
        System.out.println("isSuresiEnAzKinciIsinSuresi: " + ilanListesi.isSuresiEnAzKinciIsinSuresi(3));
        System.out.println("ucretToplamiEnBuyukKategori: " + ilanListesi.ucretToplamiEnBuyukKategori());

    }

    /**
     * Bu metot, bilmoodle testlerini üretmekte kullanılan metodun aynısıdır.
     * Verilen alt sınır ile üst sınır arasındaki rastgele bir adette iş ilanı
     * üretir. İş ilanlarının iş tanımları ve kategorileri jobs.csv dosyasından
     * alınır ve diğer özellikleri rastgele olarak oluşturulur.
     * @param lowerBound Alt sınır
     * @param upperBound Üst sınır
     * @return İş ilanları dizisi
     */
    public static IsIlani[] generateJobs(int lowerBound, int upperBound) {
        // Adeti belirle
        int adet = lowerBound + random.nextInt(upperBound - lowerBound);
        // İlan dizisini oluştur
        IsIlani[] isler = null;
        // jobs.csv'den okumak için okuyucu oluştur
        FileReader fileReader;
        try {
            // Dosyayı aç
            fileReader = new FileReader("jobs.csv");
            CSVReader reader = new CSVReader(fileReader, ';', '"', 1);
            // Tüm satırları oku
            List<String[]> jobs = reader.readAll();
            reader.close();
            // Her ilanın gün sayısının farklı olması için 1..n arasında değerler oluştur
            List<Integer> days = new ArrayList<>(jobs.size());
            // Günleri listeye ekle
            for (int i = 1; i <= jobs.size(); i++, days.add(i))
                ;
            //Listeyi karıştır ve diziye dönüştür
            Collections.shuffle(days);
            Object[] dayArray = days.toArray();
            // İş ilanlarını karıştır
            Collections.shuffle(jobs);
            // iş ilanları için diziyi oluştur
            isler = new IsIlani[adet];
            for (int i = 0; i < adet; i++) {
                String[] job = jobs.get(i);
                // İş ilanını oluşturup dizide ilgili konuma yerleştir
                isler[i] = new IsIlani(job[0],          // İş tanımı
                        job[1],                         // kategori
                        random.nextInt(500000) / 20.0,  // ücret
                        (int) dayArray[i],              // gün sayısı
                        random.nextDouble() <= 0.7);    // aktif
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isler;
    }

}
