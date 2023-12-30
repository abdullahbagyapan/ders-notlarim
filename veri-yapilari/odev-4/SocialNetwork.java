import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Verilen SocialNetwork sınıfı bir sosyal ağı temsil etmektedir. Sınıfın içinde bir kişinin ismini
 * arkadaş listesine eşleyen bir Map türünde değişken bulunmaktadır.
 * Bu sınıfın sadece mostFriendCount ve recommendedFriends metotlarını değiştirin.
 * Diğer metot ve özellikler testlerin çalışması için gereklidir.
 */
public class SocialNetwork {
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************
  // Her bir kişinin ismini arkadaş listesine eşleyen bir harita
  private Map<String, List<String>> adjacencyList;
  // Map nesnesi getter
  public Map<String, List<String>> getAdjacencyList() {
    return adjacencyList;
  }

  // Yapıcı
  public SocialNetwork() {
    adjacencyList = new HashMap<>();
  }

  // Sosyal ağa bir kişi ekler
  public void addPerson(String name) {
    if (!adjacencyList.containsKey(name)) {
      adjacencyList.put(name, new ArrayList<String>());
    }
  }

  // İki kişi arasında bir arkadaşlık ekler
  public void addFriendship(String person1, String person2) {
    addPerson(person1);
    addPerson(person2);
    if (!adjacencyList.get(person1).contains(person2)) {
      adjacencyList.get(person1).add(person2);
      adjacencyList.get(person2).add(person1);
    }
  }

  // Graftaki köşe(vertex) ve kenarların(edge) string temsilini döndürür
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Vertices:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      builder.append(person + "\n");
    }
    builder.append("\nEdges:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      List<String> friends = entry.getValue();
      builder.append(person + ": [");
      for (int i = 0; i < friends.size(); i++) {
        String friend = friends.get(i);
        if (i == friends.size() - 1) {
          builder.append(friend);
        } else {
          builder.append(friend + ", ");
        }
      }
      builder.append("]\n");
    }
    return builder.toString();
  }
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************
  /**
   * Grafta en çok arkadaşı olan kişinin arkadaş sayısını döndürür
   * @return En çok arkadaş sayısı
   */
  public int mostFriendCount() {

    int mostFriendCount = adjacencyList.values().stream().mapToInt(List::size).max().orElse(0);

    return mostFriendCount;

  }

  /**
   * Parametre olarak verilen kişi için önerilen arkadaş listesi
   * oluşturur. Önerilen arkadaş listesi aşağıdaki şekilde hesaplanır:
   * A: Parametre olarak verilen kişi
   * B: A'nın arkadaş kümesi
   * C: B'deki kişilerin arkadaşlarının kümesi
   * Öneri listesi: (B-C)-A
   * Öneri listesinde her isim sadece 1 defa yer almalıdır, ve listede
   * kişinin kendi arkadaşları ve kendisi bulunmamalıdır
   * Lütfen ödev dokümanındaki örneği inceleyiniz.
   * @param person Parametre olarak verilen kişi
   * @return Arkadaş listesi
   */
  public List<String> recommendedFriends(String person) {
    List<String> recommended = new ArrayList<>();
    List<String> friendList = adjacencyList.get(person);
    
    Set<String> recommendedFriendsList = new TreeSet<>();


    for (String friend:friendList) {
      recommendedFriendsList.addAll(adjacencyList.get(friend));
    }
    
    recommendedFriendsList.remove(person);
    recommendedFriendsList.removeAll(friendList);

    recommended.addAll(recommendedFriendsList);


    return recommended;
  }
}
