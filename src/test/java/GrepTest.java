import Grep.Grep;
import Grep.GrepLauncher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GrepTest {

    private ArrayList<String> list = new ArrayList<>();

    @Test
    public void test1() {
        Grep grep = new Grep(false, false, false);
        list.add("Мох - зеленый пол.");
        list.add("Спит зеленый дуб.");
        list.add("И, сорвав зеленый листик,");
        list.add("Отчего он не зеленый?");
        assertEquals(list, grep.options("зеленый", "C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test2() {
        Grep grep = new Grep(false, true, false);
        list.add("Зеленеют все опушки,");
        list.add("Зеленеет пруд.");
        list.add("Песенку поют.");
        list.add("Песенку завел...");
        list.add("Сели между труб.");
        list.add("Шепчет младший гном:");
        list.add("\"Видишь? Рыжий гимназистик");
        list.add("Ходит под окном.");
        list.add("Май теперь ведь... май!\"");
        list.add("Старший гном зевает сонно:");
        list.add("\"Цыц! не приставай\".");
        assertEquals(list, grep.options("зелен" ,"C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test3() {
        Grep grep = new Grep(false, true, true);
        list.add("Песенку поют.");
        list.add("Песенку завел...");
        list.add("Сели между труб.");
        list.add("Шепчет младший гном:");
        list.add("\"Видишь? Рыжий гимназистик");
        list.add("Ходит под окном.");
        list.add("Май теперь ведь... май!\"");
        list.add("Старший гном зевает сонно:");
        list.add("\"Цыц! не приставай\".");
        assertEquals(list, grep.options("зелен" ,"C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test4() {
        Grep grep = new Grep(true, false, false);
        list.add("И зелененький кузнечик");
        list.add("Два зелененькие гнома");
        assertEquals(list, grep.options("зелененький|зелененькие" ,"C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test5() {
        Grep grep = new Grep(true, false, false);
        list.add("Елка - сноп зеленых свечек,");
        list.add("Мох - зеленый пол.");
        list.add("Шепчет младший гном:");
        list.add("\"Видишь? Рыжий гимназистик");
        list.add("Отчего он не зеленый?");
        list.add("Май теперь ведь... май!\"");
        list.add("Старший гном зевает сонно:");
        list.add("\"Цыц! не приставай\".");
        assertEquals(list, grep.options("[!|?|\\-|:]", "C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test6() {
        Grep grep = new Grep(false, false, true);
        list.add("Два зелененькие гнома");
        list.add("Шепчет младший гном:");
        list.add("Старший гном зевает сонно:");
        assertEquals(list, grep.options("гнОМ", "C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test7() {
        Grep grep = new Grep(true, true, false);
        list.add("Зеленеют все опушки,");
        list.add("Зеленеет пруд.");
        list.add("Песенку поют.");
        list.add("Песенку завел...");
        list.add("Сели между труб.");
        list.add("Ходит под окном.");
        assertEquals(list, grep.options("зелен|гном|\"", "C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }

    @Test
    public void test8() {
        Grep grep = new Grep(true, true, true);
        list.add("Песенку поют.");
        list.add("Песенку завел...");
        list.add("Сели между труб.");
        list.add("Ходит под окном.");
        assertEquals(list, grep.options("зеЛен|гНОм|\"", "C:\\Users\\Admin\\IdeaProjects\\Grep\\src\\test\\input1.txt"));
        list.clear();
    }
}
