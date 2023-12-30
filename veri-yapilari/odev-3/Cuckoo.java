public class Cuckoo extends AbstractCuckoo{
    /**
     * Yapıcı metodu ve imzasını değiştirmeyin, aksi halde testleriniz çalışmaz
     */
    public Cuckoo(int max_rehash_attempts, HashTable table1, HashTable table2) {
        super(max_rehash_attempts, table1, table2);
    }

    private Integer insertTable1(int key) {

        int hash = table1.hash(key);

        Integer temp = table1.get(hash); 
        table1.set(hash, key);

        return temp;
    }
    private Integer insertTable2(int key) {

        int hash = table2.hash(key);

        Integer temp = table2.get(hash); 
        table2.set(hash, key);

        return temp;
    }

    @Override
    public boolean insert(int key) {

        int i = 0;
        int insertAttempts = 0;

        Integer temp = key;

        while (insertAttempts < MAX_REHASH_ATTEMPTS) {
            
            if (i % 2 == 0) {
                temp = insertTable1(temp);
            }
            else {
                temp = insertTable2(temp);
            }

            if (temp == null) {
                return true;
            }

            insertAttempts++;
            i++;
        }
        return false;
    }
    @Override
    public boolean search(int key) {
    
        int hash1 = table1.hash(key);
        Integer value = table1.get(hash1);

        if (value != null && value == key) {
            return true;
        }

        int hash2 = table2.hash(key);
        value = table2.get(hash2);

        if (value != null && value == key) {
            return true;
        }
        return false;
    }

}
