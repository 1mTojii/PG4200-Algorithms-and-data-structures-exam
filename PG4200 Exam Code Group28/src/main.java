public class main {
    public static void main(String[] args) {
        System.out.printf("---Welcome to our wine collection---\n" +
                "---What do you wish to see or do?---\n");



        //what we did here is we made sure to get out of main
        //as soon as possible since we learned its a good habbit
        //during our Java coding class during semester two.
        menu m = new menu();
        try {
            m.menu();
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}