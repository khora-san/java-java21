package java17.ex03;

import java17.data.Person;
import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

    //  tag::makeAChild[]
    BinaryOperator<Person> makeAChild = (p1, p2) -> {
        Person p3 = new Person();
        p3.setLastname(p1.getLastname());
        p3.setFirstname(p1.getFirstname() + " " + p2.getFirstname());
        p3.setAge(0);
        return p3;
    };
    //  end::makeAChild[]


    @Test
    public void test_makeAChild() throws Exception {

        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");

        Person child = makeAChild.apply(father, mother);

        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }

}
