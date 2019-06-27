import java.util.ArrayList;

public class AppModel {

    private int revenue;
    private ArrayList<String> emojiStock;

    // Getters
    public ArrayList<String> getEmojiStock() {
        System.out.println("       MODEL: getEmojiStock called, returning: " + emojiStock.toString());
        return emojiStock;
    }
    public int getRevenue() {
        System.out.println("       MODEL: getRevenue called, returning: " + revenue);
        return revenue;
    }

    // Constructor
    public AppModel(){
        revenue = 0;
        emojiStock = new ArrayList<>();

        emojiStock.add("O__O");
        emojiStock.add("^_^");
        emojiStock.add(":o");
        emojiStock.add(":)");
        emojiStock.add(">:(");
        emojiStock.add(":B");
        emojiStock.add(":D");
    }


    public void addToRevenue(){
        revenue += 1;
        System.out.println("       MODEL: Added to revenue, revenue is now: " + revenue);
    }

    public void removeFromEmojiStock(int index){
        System.out.println("       MODEL: removeFromEmojiStock called, attempting to remove item at index: " + index);
        if (index >= 0 && index < emojiStock.size())
            emojiStock.remove(index);
    }

}
