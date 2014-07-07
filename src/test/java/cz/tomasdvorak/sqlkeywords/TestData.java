package cz.tomasdvorak.sqlkeywords;


public class TestData {
    public static class TestEntity extends TestEntityBase {
        private String id;
        private String name;
        private String email;
    }

    public static class TestEntityBase {
        private String version;
        private String call;
        private String statement;
    }
}
