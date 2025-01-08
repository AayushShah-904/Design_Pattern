import java.util.Scanner;

/*interface hotel {
    public void order();
}

class punjabi implements hotel {
    public void order() {
        System.out.println("Punjabi food is being cooked");
    }
}

class south implements hotel {
    public void order() {
        System.out.println("South food is being cooked");
    }
}

class chinese implements hotel {
    public void order() {
        System.out.println("Chinese food is being cooked");
    }

}

class hotelfactory {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to resturant");
        do {
            System.out.println("1. Punjabi");
            System.out.println("2. South");
            System.out.println("3. Chinese");
            System.out.println("4. BillPayment");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel punjabi = new punjabi();
                    punjabi.order();
                    break;

                case 2:
                    hotel south = new south();
                    south.order();
                    break;

                case 3:
                    hotel chinese = new chinese();
                    chinese.order();
                    break;

                case 4:
                    System.out.println("Bill is being paid");
                    break;

                case 5:
                    System.out.println("Thank you for visiting");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
        {
            sc.close();
        }
    }
}*/

interface hotel {
    public void order();

    public void taste();
}

class punjabi implements hotel {
    public void order() {
        System.out.println("Punjabi food is being cooked");
    }

    public void taste() {
        System.out.println("Punjabi food is delicious");
        Scanner sc = new Scanner(System.in);
        int choice1;
        do {

            System.out.println("Taste of food");
            System.out.println("1. Spicy");
            System.out.println("2. Regular");
            System.out.println("3. Sweet");
            System.out.println("4. Exit");
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    punjabi food1 = new punjabi();
                    food1.order();
                    System.out.println("Spicy food is being prepared");
                    break;
                case 2:
                    punjabi food2 = new punjabi();
                    food2.order();
                    System.out.println("Regular food is being prepared");
                    break;
                
                case 3:
                    punjabi food3 = new punjabi();
                    food3.order();
                    System.out.println("Sweet food is being prepared");
                    break;

                case 4:
                    System.out.println("Exit");
                    break;
            }

        } while (choice1 != 4);
        {
            System.out.println("Thank You");
            sc.close();
        }
    }
}

class hotelfactory {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to resturant");
        do {
            System.out.println("1. Punjabi");
            System.out.println("2. South");
            System.out.println("3. Chinese");
            System.out.println("4. BillPayment");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel punjabi = new punjabi();
                    punjabi.order();
                    punjabi.taste();
                    break;

                case 4:
                    System.out.println("Bill is being paid");
                    break;

                case 5:
                    System.out.println("Thank you for visiting");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
        {
            sc.close();
        }
    }
}