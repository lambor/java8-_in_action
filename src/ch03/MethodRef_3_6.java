package ch03;

/**
 * Created by lambor on 17-4-28.
 */
public class MethodRef_3_6 {
    public static class Test {

        String field;

        public String instance_test(String b) {
            return field + b;
        }

        public static String static_test(Test test,String testStr) {
            return test.field + testStr;
        }

        public String instance_test2(Test test,String str) {
            return test.field + str;
        }

        public Test(String field) {
            this.field = field;
        }
    }

    public interface TestI<T1,T2,R> {
        R ti(T1 t1,T2 t2);
    }

    private static String foo(String str,Test test,TestI<Test,String,String> ti) {
        return ti.ti(test,str);
    }

    public static void main(String[] args) {
        TestI<Test,String,String> i = Test::instance_test;
        TestI<Test,String,String> j = Test::static_test;
        Test test = new Test("123");
        TestI<Test,String,String> k = test::instance_test2;
    }
}
