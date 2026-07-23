package java17.ex06;


import java17.data.Person;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {


    // tag::formatAge[]
    String formatAge(Supplier<Person> supplier) {
        Person p = supplier.get();
        String s = "[age=" + p.getAge() + "]";
        return s;
    }
    // end::formatAge[]


    @Test
    public void test_supplier_formatAge() throws Exception {

        Supplier<Person> supplier = () -> new Person("John", "France", 35, "pass");
        String result = formatAge(supplier);

        assert result.equals("[age=35]");
    }

}
