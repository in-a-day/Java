package cc.margay.pattern.iterator;

public class TestIterator {
    public static void main(String[] args) throws Exception {
        BookAggregate bookAggregate = new BookAggregate();
        bookAggregate.addBook(new Book("a"));
        bookAggregate.addBook(new Book("b"));
        bookAggregate.addBook(new Book("c"));
        bookAggregate.addBook(new Book("d"));
        Iterator<Book> bookIterator = bookAggregate.getIterator();
        while (bookIterator.hasNext()) {
            System.out.println(bookIterator.next());
        }
    }
}
