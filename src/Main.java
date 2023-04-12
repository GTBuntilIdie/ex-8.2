import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("Война и мир");
        books.add("Повесть о настоящем человеке");
        books.add("Мастер и Маргарита");
        books.add("Сказки");
        books.add("Му-Му");
        books.add("Том Сойер");
        books.add("Два капитана");
        books.add("Капитанская дочка");

        List<ArrayList<String>> abs = getBookShelves(books);
        abs.stream().forEach(System.out::println);

    // Необходимо реализовать следующий метод:
    // 1. На вход получаем список названий книг
    // 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
    // 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
    // 4. Количество полок константное - 5 штук
    // 5. Вернуть книги распределенные по полкам

    }
    public static List<ArrayList<String>> getBookShelves (List<String> books) {

        books.stream().sorted()
                .collect(Collectors.toList());

        List<ArrayList<String>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(i, shelf);

        }
        int boolIndex = 0;
        int shelfIndex = 0;
        while (boolIndex < books.size()) {
            int bookOnShelf = getBooksOnShelves(books.size() , shelves.size() ) ;
            for ( int i = 0; i < bookOnShelf; i++) {
                shelves.get(shelfIndex).add(books.get(boolIndex));
                boolIndex++;
            }
            shelfIndex++;

        }
        return shelves;
    }

    public static int getBooksOnShelves( int book, int shelves) {
        int bookOnShelves = book / shelves;
        if (shelves * bookOnShelves < book) {
            bookOnShelves++;
        }
        return bookOnShelves;
    }

}