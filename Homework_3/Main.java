public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4, 5);
        list.add(5, 6);
        list.add(6, 7);

        System.out.print("Array: ");
        for(int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }

        Integer num = 2;
        list.remove(num);

        list.remove(0);

        System.out.println();
        System.out.println("Contains 5?: " + list.contains(5));
        System.out.println("Index of 6: " + list.indexOf(6));
        System.out.println("Get 4th index elem: " + list.get(4));
        System.out.println("Is empty?: " + list.isEmpty());
    }
}
