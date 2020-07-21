package cc.margay.pattern.iterator;

public class BookIterator implements Iterator<Book>{
    private BookAggregate bookAggregate;
    private int currentIndex = 0;

    private BookIterator(BookAggregate bookAggregate) {
        this.bookAggregate = bookAggregate;
    }

    public static BookIterator of(BookAggregate bookAggregate) {
        return new BookIterator(bookAggregate);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < bookAggregate.getBooks().size();
    }

    @Override
    public Book next() throws Exception {
        if (!hasNext()) throw new Exception("no more books");
        return bookAggregate.getBooks().get(currentIndex++);
    }
}
