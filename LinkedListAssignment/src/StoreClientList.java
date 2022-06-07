public class StoreClientList {

    public static void main(String args[]) {
        ToyStoreManager store = new ToyStoreManager("Baseball-5.99 Barbie-9.99 Barbie-9.99 Slinky-3.99 Jenga-15.99 Baseball-5.99 Jenga-15.99 Jenga-15.99");
        System.out.println(store);
        System.out.println();


        System.out.println("Toy most frequently bought: " + store.getMostFrequentToy());
        System.out.println();


    }
}
