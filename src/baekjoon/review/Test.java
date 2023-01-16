package baekjoon.review;

public class Test <T> extends ParentTest {

    private T data;

    public Test(T data) {
        super();
        this.data = data;
    }

}

class ParentTest {
    private String code;

    public ParentTest() {
        code = "1";
    }

    public ParentTest(String code) {
        this.code = code;
    }
}

class TestSample {

}
