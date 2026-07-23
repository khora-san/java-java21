package java17.ex02;

import java17.data.Data;
import java17.data.Person;
import org.junit.Test;

import java.util.List;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        default String format() {
            return "[" + findAll().size() + " persons]";
        }
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        @Override
        public String format() {
            return "DaoA" + IDao.super.format();
        }

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();
        String result = daoA.format();
        assert "DaoA[20 persons]".equals(result);
    }
}
