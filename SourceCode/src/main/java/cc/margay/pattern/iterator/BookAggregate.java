package cc.margay.pattern.iterator;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookAggregate implements Aggregate<Book>{
    private List<Book> books = new ArrayList<>();

    @Override
    public Iterator getIterator() {
        return BookIterator.of(this);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(@NotNull Book book) {
        Objects.requireNonNull(book);
        books.add(book);
    }
}
