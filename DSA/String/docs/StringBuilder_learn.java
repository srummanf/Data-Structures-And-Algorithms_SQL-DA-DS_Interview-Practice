public class StringBuilder_learn {

    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
        
        // char at index 0
        System.out.println(sb.charAt(0));
        
        // set char at index 0
        sb.setCharAt(0, 'p');
        System.out.println(sb);

        // insert at index 0
        sb.insert(0, 'H');
        System.out.println(sb);

        // delete at index 0
        sb.deleteCharAt(0);
        System.out.println(sb);

        // delete from index 0 to 2
        sb.delete(0, 2);
        System.out.println(sb);

        // reverse
        sb.reverse();
        System.out.println(sb);

        // length
        System.out.println(sb.length());
}
}